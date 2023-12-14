package Project.client.views;

import java.io.*;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

import Project.client.Card;
import Project.client.Client;
import Project.client.ICardControls;
import Project.client.IGameEvents;
import Project.common.Phase;

public class GamePanel extends JPanel implements IGameEvents {
    private CardLayout cardLayout;
    private JPanel triviaPanel = new JPanel();
    private JEditorPane cat = new JEditorPane();
    private JEditorPane ques = new JEditorPane();
    private JButton a1 = new JButton();
    private JButton a2 = new JButton();
    private JButton a3 = new JButton();
    private JButton a4 = new JButton();
    private JEditorPane timer = new JEditorPane();

    public GamePanel(ICardControls controls) {
        super(new CardLayout());
        cardLayout = (CardLayout) this.getLayout();
        this.setName(Card.GAME_SCREEN.name());
        Client.INSTANCE.addCallback(this);
        // this is purely for debugging
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println("GamePanel Resized to " + e.getComponent().getSize());
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                // System.out.println("Moved to " + e.getComponent().getLocation());
            }
        });
        createReadyOrCreatePanel();
        createIntroPanel();
        createOptionsPanel();
        createEndPanel();
        setVisible(false);
        // don't need to add this to ClientUI as this isn't a primary panel(it's nested
        // in ChatGamePanel)
        // controls.addPanel(Card.GAME_SCREEN.name(), this);
    }

    private void createReadyOrCreatePanel() {
        JPanel readyPanel = new JPanel();
        JButton readyButton = new JButton();
        JEditorPane createQuestion = new JEditorPane();
        // 12/13/2023 rr268
        JLabel cate = new JLabel("Category:");
        JLabel quest = new JLabel("Question:");
        JLabel options = new JLabel("Options: (format it like 'option1, option2, option3')");
        JLabel correct = new JLabel("Correct Answer:");
        JTextField cat = new JTextField();
        JTextField ques = new JTextField();
        JTextField opts = new JTextField();
        JTextField correctAnswer = new JTextField();
        JButton submit = new JButton("submit question");
        readyPanel.setLayout(new BoxLayout(readyPanel, BoxLayout.Y_AXIS));
        createQuestion.setContentType("text/plain");
        createQuestion.setText("Create a Question here aswell before you ready up if you want.");
        readyButton.setText("Ready");
        readyButton.addActionListener(l -> {
            try {
                Client.INSTANCE.sendReadyStatus();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        readyPanel.add(readyButton);
        readyPanel.add(createQuestion);
        readyPanel.add(cate);
        readyPanel.add(cat);
        cat.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submit.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
        readyPanel.add(quest);
        readyPanel.add(ques);
        ques.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submit.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
        readyPanel.add(options);
        readyPanel.add(opts);
        opts.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submit.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
        readyPanel.add(correct);
        readyPanel.add(correctAnswer);
        correctAnswer.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submit.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
        // 12/13/2023 rr268
        submit.addActionListener((event) -> {
            try {
                String catText = cat.getText().trim();
                String quesText = ques.getText().trim();
                String optsText = opts.getText().trim();
                String correctText = correctAnswer.getText().trim();

                BufferedWriter out = new BufferedWriter(
                    new FileWriter("Project/server/questions/Questions.txt", true)
                );
                
                out.newLine();
                out.write("Category: " + catText);
                out.newLine();
                out.write("Question: " + quesText);
                out.newLine();
                out.write("Answers: " + optsText);
                out.newLine();
                out.write("CorrectAnswer: " + correctText);

                out.close();

                if (catText.length() > 0) {
                    cat.setText("");// clear the original text
                }
                if (quesText.length() > 0) {
                    ques.setText("");// clear the original text
                }
                if (optsText.length() > 0) {
                    opts.setText("");// clear the original text
                }
                if (correctText.length() > 0) {
                    correctAnswer.setText("");// clear the original text
                }
            } catch (NullPointerException e) {
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        readyPanel.add(submit);
        //
        add(readyPanel);
    }

    private void createIntroPanel(){
        JPanel introPanel = new JPanel();
        JEditorPane intro = new JEditorPane();
        intro.setContentType("text/plain");
        intro.setText("Welcome to Trivia Night!");
        introPanel.add(intro);
        add(introPanel);
    }

    private void createEndPanel(){
        JPanel endPanel = new JPanel();
        JEditorPane end = new JEditorPane();
        end.setContentType("text/plain");
        end.setText("Thank you for playing Trivia night!");
        endPanel.add(end);
        add(endPanel);
    }

    private void createOptionsPanel(){ 
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JButton away = new JButton("AWAY");
        JButton here = new JButton("HERE");
        ques.setContentType("text/plain");
        triviaPanel.add(ques);
        cat.setContentType("text/plain");
        triviaPanel.add(cat);
        a1.addActionListener(l ->{
            try {
                Client.INSTANCE.sendAnswer(a1.getText());
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        });
        triviaPanel.add(a1);
        a2.addActionListener(l ->{
            try {
                Client.INSTANCE.sendAnswer(a2.getText());
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        });
        triviaPanel.add(a2);
        a3.addActionListener(l ->{
            try {
                Client.INSTANCE.sendAnswer(a3.getText());
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        });
        triviaPanel.add(a3);
        a4.addActionListener(l ->{
            try {
                Client.INSTANCE.sendAnswer(a4.getText());
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        });
        triviaPanel.add(a4);
        timer.setContentType("text/plain");
        triviaPanel.add(timer);
        // 12/13/2023 rr268
        triviaPanel.add(away);
        away.addActionListener(l ->{
            try {
                Client.INSTANCE.sendAwayStatus();
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        });
        triviaPanel.add(here);
        here.addActionListener(l ->{
            try {
                Client.INSTANCE.sendAwayStatus();
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        });
        //
        add(triviaPanel);
    }


    @Override
    public void onClientConnect(long id, String clientName, String message) {
    }

    @Override
    public void onClientDisconnect(long id, String clientName, String message) {
    }

    @Override
    public void onMessageReceive(long id, String message) {
    }

    @Override
    public void onReceiveClientId(long id) {
    }

    @Override
    public void onSyncClient(long id, String clientName) {
    }

    @Override
    public void onResetUserList() {
    }

    @Override
    public void onReceiveRoomList(String[] rooms, String message) {
    }

    @Override
    public void onRoomJoin(String roomName) {
    }

    @Override
    public void onReceiveAnswer(long id, String answer){
    }

    @Override
    public void onReceiveQuestion(String question){
        ques.setText(question);
        
    }

    @Override
    public void onReceiveCategory(String category){
        cat.setText(category);
    }

    @Override
    public void onReceiveOptions(String options){
        options = options.replace("Answers:", "");
        String[] opts = options.split(",", 4);
        a1.setText(opts[0].trim());
        a2.setText(opts[1].trim());
        a3.setText(opts[2].trim());
        a4.setText(opts[3].trim());
    }

    public void onReceiveTime(int time){
        timer.setText("" + time);
        timer.revalidate();
        timer.repaint();
    }


    @Override
    public void onReceivePhase(Phase phase) {
        // I'll temporarily do next(), but there may be scenarios where the screen can
        // be inaccurate
        System.out.println("Received phase: " + phase.name());
        if (phase == Phase.READY) {
            if (!isVisible()) {
                setVisible(true);
                this.getParent().revalidate();
                this.getParent().repaint();
                System.out.println("GamePanel visible");
            } else {
                cardLayout.next(this);
            }
        } else if (phase == Phase.SELECTION) {
            //System.out.println("Game has started");
            cardLayout.next(this);      
        } else if(phase == Phase.GAME){
            cardLayout.next(this);
        } else if(phase == Phase.END){
            cardLayout.next(this);
        } 

    }

    @Override
    public void onReceiveReady(long clientId) {
    }

}