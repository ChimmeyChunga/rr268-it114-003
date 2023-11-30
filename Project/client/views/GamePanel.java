package Project.client.views;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
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
        createReadyPanel();
        createIntroPanel();
        createOptionsPanel();
        createEndPanel();
        setVisible(false);
        // don't need to add this to ClientUI as this isn't a primary panel(it's nested
        // in ChatGamePanel)
        // controls.addPanel(Card.GAME_SCREEN.name(), this);
    }

    private void createReadyPanel() {
        JPanel readyPanel = new JPanel();
        JButton readyButton = new JButton();
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