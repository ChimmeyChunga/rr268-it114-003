package Project.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Project.common.Constants;
import Project.common.Phase;
import Project.common.TimedEvent;


public class GameRoom extends Room {
    Phase currentPhase = Phase.READY;
    private static Logger logger = Logger.getLogger(GameRoom.class.getName());
    private TimedEvent readyTimer = null;
    private TimedEvent scoreCheck = null;
    //private TimedEvent reset = null;
    //private TimedEvent question = null;
    private ConcurrentHashMap<Long, ServerPlayer> players = new ConcurrentHashMap<Long, ServerPlayer>();
    private List<Integer> questionNum = new ArrayList<>();
    private String correct;
    private List<ServerThread> answerOrder = new ArrayList<>();
    private int answerIndex = 0;
    private int quesIndex = 0;
    private int maxQues = 3;
    public GameRoom(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void addClient(ServerThread client) {
        logger.info("Adding client as player");
        players.computeIfAbsent(client.getClientId(), id -> {
            ServerPlayer player = new ServerPlayer(client);
            super.addClient(client);
            logger.info(String.format("Total clients %s", clients.size()));// change visibility to protected
            return player;
        });
    }

    protected void setReady(ServerThread client) {
        logger.info("Ready check triggered");
        if (currentPhase != Phase.READY) {
            logger.warning(String.format("readyCheck() incorrect phase: %s", Phase.READY.name()));
            return;
        }
        if (readyTimer == null) {
            sendMessage(null, "Ready Check Initiated, 30 seconds to join");
            readyTimer = new TimedEvent(30, () -> {
                readyTimer = null;
                readyCheck(true);
            });
        }
        // Hashmaps allow fast lookup by keys
        if(players.containsKey(client.getClientId())){
            ServerPlayer sp = players.get(client.getClientId());
            sp.setReady(true);
            logger.info(String.format("Marked player %s[%s] as ready", sp.getClient().getClientName(), sp
                            .getClient().getClientId()));
                    syncReadyStatus(sp.getClient().getClientId());
        }
        /* Example demonstrating stream api and filters (not ideal in this scenario since a hashmap has a more officient approach) 
        * This concept may be beneficial in the future for other lookup data
        players.values().stream().filter(p -> p.getClient().getClientId() == client.getClientId()).findFirst()
                .ifPresent(p -> {
                    p.setReady(true);
                    logger.info(String.format("Marked player %s[%s] as ready", p.getClient().getClientName(), p
                            .getClient().getClientId()));
                    syncReadyStatus(p.getClient().getClientId());
                });*/
        readyCheck(false);
    }

    private void readyCheck(boolean timerExpired) {
        if (currentPhase != Phase.READY) {
            return;
        }
        // two examples for the same result
        // int numReady = players.values().stream().mapToInt((p) -> p.isReady() ? 1 :
        // 0).sum();
        long numReady = players.values().stream().filter(ServerPlayer::isReady).count();
        if (numReady >= Constants.MINIMUM_PLAYERS) {

            if (timerExpired) {
                sendMessage(null, "Ready Timer expired, starting session");
                start();
            } else if (numReady >= players.size()) {
                sendMessage(null, "Everyone in the room marked themselves ready, starting session");
                if (readyTimer != null) {
                    readyTimer.cancel();
                    readyTimer = null;
                }
                start();
            }

        } else {
            if (timerExpired) {
                resetSession();
                sendMessage(null, "Ready Timer expired, not enough players. Resetting ready check");
            }
        }
    }

    private void start() {
        updatePhase(Phase.SELECTION);
        // TODO example
        
        //File questions = new File("Project/server/questions/Questions");
        //File[] questions = dir.listFiles();
        //long numAnswered = players.values().stream().filter(ServerPlayer::hasAnswered).count();
        try{
            sendMessage(null, "Welcome to Speed Trivia Night!");
            Thread.sleep(1000);
            sendMessage(null, "Here is a quick run down on how it works.");
            Thread.sleep(1000);
            sendMessage(null, "You all are given the same random question from a random category and have 30 seconds to select one of the four potential answers.");
            Thread.sleep(1000);
            sendMessage(null, "To answer the question do /answer 'potential answer'.");
            Thread.sleep(1000);
            sendMessage(null, "Those who answer correctly faster than others will get more points.");
            Thread.sleep(1000);
            sendMessage(null, "After 3 questions the game is over and scores are final.");
            Thread.sleep(1000);
            sendMessage(null, "Have fun, the first question is about to popup!");
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            
        }
        // rr268, 11/13/2023
        
        for (int i = 0; i < 5; i++) {
            questionNum.add(i);
        }
        Collections.shuffle(questionNum); 
        round(questionNum); //uncomment this 
        // rr268, 11/13/2023
        /* 
        Trivia(questionNum.get(0));
        for (int i = 1; i < 3; i++){
            int num = questionNum.get(i);
            new TimedEvent((i*30), () -> computeScore());
            new TimedEvent((i*31), () -> {answerIndex = 0;});
            new TimedEvent((i*31), () -> Trivia(num));
            if(i == 2){
                new TimedEvent((3*30), () -> computeScore());
                new TimedEvent((3*31), () -> {answerIndex = 0;});
            }
        }    
        new TimedEvent(100, () -> resetSession());
        */
    }

    private void round(List<Integer> questionNum){
        Trivia(questionNum.get(quesIndex));
        scoreCheck = new TimedEvent(30, () -> {
            computeScore();
            answerIndex = 0;
            round(questionNum);
        });
        if(quesIndex >= maxQues){     
            scoreCheck.cancel();
            quesIndex = 0;
            resetSession();
        }
        else
            quesIndex++;
        
        
    }
    //rr268, 11/08/2023
    private void Trivia(int quesNum){
        //Random rand = new Random();
        //File question = questions[rand.nextInt(questions.length)];
        try{
            //Scanner readQues = new Scanner(questions);
            int quesLine = (4 * quesNum);
            List<String> allQuestions = Files.readAllLines(Paths.get("Project/server/questions/Questions.txt"));
            for (int i = 0; i < 4; i++){
                String ques = allQuestions.get(quesLine + i); 
                if(i == 3){
                    correct = ques.replace("CorrectAnswer:", "").trim();
                }
                else{
                    sendMessage(null, ques);
                }
            }
            //correct = readQues.nextLine().replace("CorrectAnswer:", "").trim();
            //readQues.close();
        }
        catch(IOException e)
        {

        }
            
    }

    protected void checkAnswers(String answer, ServerThread client){ 
        ServerPlayer sp = players.get(client.getClientId());    
        if (answer.equalsIgnoreCase(correct)){
            client.sendAnswer(client.getClientId(), answer);
            //sendMessage(null, "Your answer " + answer + " is correct!");
            answerOrder.add(answerIndex, client); 
            sp.setAnswer(true);
            answerIndex++;
        }
        else{
            sendMessage(null, "Your answer is wrong");
            sp.setAnswer(true);
        }
        long numAnswered = players.values().stream().filter(ServerPlayer::hasAnswered).count();
        
        if(numAnswered >= players.size()){
            scoreCheck.cancel();
            computeScore();
            answerIndex = 0;
            round(questionNum);
            players.values().stream().forEach(p -> p.setAnswer(false));
        }
        
    }
    //rr268, 11/13/2023
    private void computeScore(){
        for(int i = 0; i < answerIndex; i++){
            if(i == 0){
                ServerPlayer sp = players.get(answerOrder.get(i).getClientId());
                sp.setScore(100);
            }
            else if(i == 1){
                ServerPlayer sp = players.get(answerOrder.get(i).getClientId());
                sp.setScore(75);
            }
            else if(i == 2){
                ServerPlayer sp = players.get(answerOrder.get(i).getClientId());
                sp.setScore(50);
            }
            else{
                ServerPlayer sp = players.get(answerOrder.get(i).getClientId());
                sp.setScore(25);
            }
        }
        //rr268, 11/15/2023
        Integer[] ranking = new Integer[players.size()];
        for(int i = 0; i < answerIndex; i++){
            ServerPlayer sp = players.get(answerOrder.get(i).getClientId());
            sendMessage(null, sp.getClient().getClientName() + " has " + sp.getScore() + " points!");
            sp.getClient().sendScore(sp.getClient().getClientId(), sp.getScore());
            ranking[i] = sp.getScore();
        }
        String leader = "";
        String second = "";
        String third = "";
        for(int i = 0; i < ranking.length; i++){
            Arrays.sort(ranking, Collections.reverseOrder());
            ServerPlayer sp = players.get(answerOrder.get(i).getClientId());
            if(sp.getScore() == ranking[0]){
                leader = sp.getClient().getClientName();
            }
            else if(sp.getScore() == ranking[1]){
                second = sp.getClient().getClientName();
            }
            else if(sp.getScore() == ranking[2]){
                third = sp.getClient().getClientName();
            }
        }
    
        sendMessage(null, leader + " is in the lead with " + ranking[0] + " points!");
        sendMessage(null, second + " is in in second with " + ranking[1] + " points!");
        if(ranking[2] != null)
            sendMessage(null, third + " is in in third with" + ranking[2] + " points!");

        players.values().stream().forEach(p -> p.setAnswer(false));
    }
//
    private synchronized void resetSession() {
        players.values().stream().forEach(p -> p.setReady(false));
        players.values().stream().forEach(p -> p.setAnswer(false));
        updatePhase(Phase.READY);
        sendMessage(null, "Session ended, please intiate ready check to begin a new one");
    }

    private void updatePhase(Phase phase) {
        if (currentPhase == phase) {
            return;
        }
        currentPhase = phase;
        // NOTE: since the collection can yield a removal during iteration, an iterator
        // is better than relying on forEach
        Iterator<ServerPlayer> iter = players.values().stream().iterator();
        while (iter.hasNext()) {
            ServerPlayer client = iter.next();
            boolean success = client.getClient().sendPhaseSync(currentPhase);
            if (!success) {
                handleDisconnect(client);
            }
        }
    }

    protected void handleDisconnect(ServerPlayer player) {
        if (players.containsKey(player.getClient().getClientId())) {
            players.remove(player.getClient().getClientId());
            super.handleDisconnect(null, player.getClient()); // change visibility to protected
            logger.info(String.format("Total clients %s", clients.size()));
            sendMessage(null, player.getClient().getClientName() + " disconnected");
            if (players.isEmpty()) {
                close();
            }
        }
    }

    private void syncReadyStatus(long clientId) {
        Iterator<ServerPlayer> iter = players.values().stream().iterator();
        while (iter.hasNext()) {
            ServerPlayer client = iter.next();
            boolean success = client.getClient().sendReadyStatus(clientId);
            if (!success) {
                handleDisconnect(client);
            }
        }
    }
}