package Project.server;

import java.io.BufferedReader;
import java.io.FileReader;
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
    private int maxQues = 5;
    private boolean gameEnd = false;
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
            syncGameState(client);
            logger.info(String.format("Total clients %s", clients.size()));// change visibility to protected
            return player;
        });
    }
    
    private void syncGameState(ServerThread incomingClient) {
        // single data
        // sync grid
        incomingClient.sendPhaseSync(currentPhase);
        Iterator<ServerPlayer> iter = players.values().stream().iterator();
        while (iter.hasNext()) {
            ServerPlayer client = iter.next();
            if (client.getClient().getClientId() == incomingClient.getClientId()) {
                continue;
            }
            boolean success = false;
            if (client.isReady()) {
                success = incomingClient.sendReadyStatus(client.getClient().getClientId());
            }

            if (!success) {
                break;
            }
        }
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

        // rr268 11/29/2023
        Iterator<ServerPlayer> iter = players.values().stream().iterator();
        while (iter.hasNext()) {
            ServerPlayer c = iter.next();
            c.setAnswer(false);
            c.setScore(0);
        }
        updatePhase(Phase.SELECTION);
        int lines;
        int numQues = 0;
        try{
        BufferedReader reader = new BufferedReader(new FileReader("Project/server/questions/Questions.txt"));
        lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        numQues = lines/4;
        }
        catch(Exception e){

        }
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
        for (int i = 0; i < numQues; i++) {
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
    //rr268, 11/15/2023, 11/29/2023
    private void round(List<Integer> questionNum){
        Iterator<ServerPlayer> iter = players.values().stream().iterator();
        int winner = 500;    
        while (iter.hasNext()) {
            ServerPlayer p = iter.next();
            if(p.getScore() >= winner){
                scoreCheck.cancel();
                quesIndex = 0;
                answerIndex= 0;
                answerOrder.clear();
                gameEnd = true;
                sendMessage(null, "Winner is " + p.getClient().getClientName());
                updatePhase(Phase.END);
                new TimedEvent(10, () -> {
                    resetSession();
                });
                break;
            }
        }
        // this is for testing purposes it will be commented out in the future
        /*if(quesIndex >= maxQues){     
            scoreCheck.cancel();
            quesIndex = 0;
            answerIndex= 0;
            answerOrder.clear();
            /* 
            players.values().stream().forEach(p -> p.setAnswer(false));
            Iterator<ServerPlayer> iter = players.values().stream().iterator();
            while (iter.hasNext()){
                ServerPlayer client = iter.next();
                client.setScore(0);
            }
            
            updatePhase(Phase.END);
            new TimedEvent(10, () -> {
                resetSession();
            });
        }*/
       // else{
        if(gameEnd == false){
            Trivia(questionNum.get(quesIndex));
            updatePhase(Phase.GAME);
            scoreCheck = new TimedEvent(30, () -> {
                computeScore();
                answerIndex = 0;
                while (iter.hasNext()) {
                    ServerPlayer c = iter.next();
                    c.setAnswer(false);
                }
                answerOrder.clear();
                sendMessage(null, "Time is up on to the next");
                updatePhase(Phase.GAME);
                round(questionNum);
            })/* .setTickCallback((time) -> {
                sendTime(time);
            })*/;
            quesIndex++;
        }
    //}    
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
                //rr 268, 11/08/2023
                else if(i == 2){
                    sendOptions(ques);
                }
                else if(i == 1){
                    sendQuestion(ques);
                }
                else if(i == 0){
                    sendCategory(ques);
                }
                // Change this to (if == 0) to send category (if == 1) to send question and (if== 2) to send answers
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
    //
    private void sendTime(int time){
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread client = iter.next();
            client.sendTime(time);
        }
    }

    private void sendQuestion(String ques){
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread client = iter.next();
            client.sendQuestion(ques);
        }
    }

    private void sendCategory(String cat){
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread client = iter.next();
            client.sendCategory(cat);
        }
    }

    private void sendOptions(String options){
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread client = iter.next();
            client.sendOptions(options);
        }
    }
    
    //rr268, 11/13/2023
    protected void checkAnswers(String answer, ServerThread client){ 
        ServerPlayer sp = players.get(client.getClientId());  
        if(sp.hasAnswered() == false && sp.isAway() == false){
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
        }
        else if(sp.isAway() == true){
            sendMessage(null, "You are currently away please select here to get back in the game");
        }
        else{
            sendMessage(null, "You have already answered");
        }
        long numAnswered = players.values().stream().filter(ServerPlayer::hasAnswered).count();
        long numRdy = players.values().stream().filter(ServerPlayer::isReady).count();
        //rr268, updated 12/13/23
        if(numAnswered >= numRdy){
            scoreCheck.cancel();
            computeScore();
            answerIndex = 0;
            answerOrder.clear();
            Iterator<ServerPlayer> iter = players.values().stream().iterator();
            while (iter.hasNext()) {
                ServerPlayer c = iter.next();
                c.setAnswer(false);
            }
            round(questionNum);
            //players.values().stream().forEach(p -> p.setAnswer(false));
        }
        
    }
    //rr268, 11/13/2023
    private void computeScore(){
        List<Integer> ranking = new ArrayList<>();
        if(answerIndex == 0){
            Iterator<ServerPlayer> iter = players.values().stream().iterator();
            while (iter.hasNext()) {
                ServerPlayer client = iter.next();
                client.getClient().sendScore(client.getClient().getClientId(), client.getScore());
                sendMessage(null, client.getClient().getClientName() + " has " + client.getScore() + " points!");
                ranking.add(answerIndex, client.getScore());
            }
        }
        else{
            for(int i = 0; i < answerOrder.size(); i++){
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
                //rr268, 11/15/2023
            }    
            Iterator<ServerPlayer> iter = players.values().stream().iterator();
            while (iter.hasNext()) {
                ServerPlayer client = iter.next();
                if(client.isReady()){
                    client.getClient().sendScore(client.getClient().getClientId(), client.getScore());
                    sendMessage(null, client.getClient().getClientName() + " has " + client.getScore() + " points!");
                    ranking.add(client.getScore());
                }
            }
    }
        
        String leader = "";
        String second = "";
        //String third = "";
        //for(int i = 0; i < ranking.size(); i++){
            Iterator<ServerPlayer> iter = players.values().stream().iterator();
            Collections.sort(ranking, Collections.reverseOrder());
            while (iter.hasNext()){
                //ServerPlayer sp = players.get(answerOrder.get(i).getClientId());
                ServerPlayer sp = iter.next();
                if(sp.getScore() == ranking.get(0)){
                    leader = sp.getClient().getClientName();
                }
                else if(sp.getScore() == ranking.get(1)){
                    second = sp.getClient().getClientName();
                }
            }
            //else if(sp.getScore() == ranking.get(2)){
                //third = sp.getClient().getClientName();
            //}
            //}
    
        sendMessage(null, leader + " is in the lead with " + ranking.get(0) + " points!");
        sendMessage(null, second + " is in in second with " + ranking.get(1) + " points!");
        //if(ranking.size() >= 2)
            //sendMessage(null, third + " is in in third with" + ranking.get(2) + " points!");

        players.values().stream().forEach(p -> p.setAnswer(false));
    }
//
    protected void setAway(ServerThread client){
        if(players.containsKey(client.getClientId())){
            ServerPlayer sp = players.get(client.getClientId());
            if(sp.isAway() == false){
                sp.setAway(true);
                sendMessage(null, client.getClientName() + " has stepped away.");
                sp.setReady(false);
            }
            else{
                sp.setAway(false);
                sendMessage(null, client.getClientName() + " came back!");
                sp.setReady(true);
            }
        }
    }

    private synchronized void resetSession() {
        //players.values().stream().forEach(p -> p.setReady(false));
        Iterator<ServerPlayer> iter = players.values().stream().iterator();
        while (iter.hasNext()) {
            ServerPlayer c = iter.next();
            c.setAnswer(false);
            c.setScore(0);
            c.setReady(false);
        }
        correct = "";
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