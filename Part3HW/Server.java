package Part3HW;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Server {
    int port = 3001;
    // connected clients
    private List<ServerThread> clients = new ArrayList<ServerThread>();

    private void start(int port) {
        this.port = port;
        // server listening
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket incoming_client = null;
            System.out.println("Server is listening on port " + port);
            do {
                System.out.println("waiting for next client");
                if (incoming_client != null) {
                    System.out.println("Client connected");
                    ServerThread sClient = new ServerThread(incoming_client, this);
                    
                    clients.add(sClient);
                    sClient.start();
                    incoming_client = null;
                    
                }
            } while ((incoming_client = serverSocket.accept()) != null);
        } catch (IOException e) {
            System.err.println("Error accepting connection");
            e.printStackTrace();
        } finally {
            System.out.println("closing server socket");
        }
    }
    protected synchronized void disconnect(ServerThread client) {
		long id = client.threadId();
        client.disconnect();
		broadcast("Disconnected", id);
	}
    
    protected synchronized void broadcast(String message, long id) {
        if(processCommand(message, id)){

            return;
        }
        // let's temporarily use the thread id as the client identifier to
        // show in all client's chat. This isn't good practice since it's subject to
        // change as clients connect/disconnect
        message = String.format("User[%d]: %s", id, message);
        // end temp identifier
        
        // loop over clients and send out the message
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
            boolean wasSuccessful = client.send(message);
            if (!wasSuccessful) {
                System.out.println(String.format("Removing disconnected client[%s] from list", client.threadId()));
                it.remove();
                broadcast("Disconnected", id);
            }
        }
    }

    private boolean processCommand(String message, long clientId){
        System.out.println("Checking command: " + message);
        if(message.equalsIgnoreCase("disconnect")){
            Iterator<ServerThread> it = clients.iterator();
            while (it.hasNext()) {
                ServerThread client = it.next();
                if(client.threadId() == clientId){
                    it.remove();
                    disconnect(client);
                    
                    break;
                }
            }
            return true;
        }
        /*  rr268/ 10/16/2023 / 
         I was able to implement this feature by going to the processCommand() method and adding an else if to check if the user enters the command "coinflip", if that command is entered it a "coinside" 
         variable is created and then  an if statement checks a simple math.random to get either a 1 or 0 If greater then .5 then it is heads and else it would be tails. Finally takes that "coinside" with a 
         simple string statement and passes it through to the serverthread send method that broadcasts that coinflip into the server with who it came from.
        */
        else if(message.equalsIgnoreCase("coinflip")){
            Iterator<ServerThread> it = clients.iterator();
            while (it.hasNext()){
                ServerThread client = it.next();
                if(client.threadId() == clientId){
                    String coinSide = "";
                    if(Math.random() < .5){
                        coinSide = clientId +" got Heads!";
                        boolean wasSuccessful = client.send(coinSide);
                        broadcast(coinSide, clientId);
                        if (!wasSuccessful) {
                            System.out.println(String.format("An Erroer occured with client[%s] from list", client.threadId()));
                            it.remove();
                            broadcast("An erroer occured", clientId);
                        }
                    }
                    else{
                        coinSide = clientId + " got Tails!";
                        boolean wasSuccessful = client.send(coinSide);
                        broadcast(coinSide, clientId);
                        if(!wasSuccessful){
                            System.out.println(String.format("An Erroer occured with client[%s] from list", client.threadId()));
                            it.remove();
                            broadcast("An erroer occured", clientId);
                        }
                    }
                }
            }
            return true;
            // coinflip code ends here
        }
        /* rr268/ 10/16/2023 /
         * Much like the first feature this feature was implemented inside of the processCommand() method as an else if statement to check if that message starts with the command "shuffle". If that command is 
         * inputted the code then takes out the shuffle part of the command with a replace function then takes what is left into a new message variable. That new message is then put into a character list holding 
         * all of its characters, after that a StringBuilder object is made. Then a while loop is made in which a random number variable is made by math.random and in range of the size for the character list, then 
         * that random number is used to go a certain index inside of the character list which is appended into the stringbuilder object and also removed from the character list so no repeats of a character is made 
         * when creating a new string. This is all done to shuffle the message and eventual make a new string that is passed through the send() method inside of the ServerThread class that broadcasts to the server 
         * that the user shuffled their message.                
          */
        else if(message.startsWith("shuffle")){    // tried some regex couldnt get it working\\(^[a-z]+$)\\
            Iterator<ServerThread> it = clients.iterator();
            while (it.hasNext()){
                ServerThread client = it.next();
                if(client.threadId() == clientId){
                    String newMessage = message.replace("shuffle ","");
                    //System.out.println(newMessage);
                    List<Character> charlist = new ArrayList<Character>();
                    for(char c:newMessage.toCharArray()){
                        charlist.add(c);
                    }
                    StringBuilder shuffMsg = new StringBuilder(newMessage.length());
                    while(charlist.size()!=0){
                        int randNum = (int)(Math.random()*charlist.size());
                        shuffMsg.append(charlist.remove(randNum));
                    }
                    boolean wasSuccessful = client.send("User "+ clientId + " shuffled their message: " + shuffMsg.toString());
                    String finalMsg = shuffMsg.toString();
                    broadcast(finalMsg, clientId);
                    if(!wasSuccessful){
                        System.out.println(String.format("An Erroer occured with client[%s] from list", client.threadId()));
                        it.remove();
                        broadcast("An erroer occured", clientId);
                    }
                }

            }
            return true;
        }
        // shuffle command code ends here
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Starting Server");
        Server server = new Server();
        int port = 3000;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            // can ignore, will either be index out of bounds or type mismatch
            // will default to the defined value prior to the try/catch
        }
        server.start(port);
        System.out.println("Server Stopped");
    }
}
