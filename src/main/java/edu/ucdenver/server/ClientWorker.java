package edu.ucdenver.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class ClientWorker implements Runnable {

    private Server server;
    private Socket connection;
    private Boolean keepRunningClient;
    private PrintWriter output;
    private BufferedReader input;


    public ClientWorker(Server server, Socket socket){
        this.connection = socket;
        this.server = server;
        this.keepRunningClient = true;
    }

    @Override
    public void run() {
        BufferedReader input;
        PrintWriter output;
        String newMessage;

        displayMessage("Getting Data Streams");

        try{
            output = getOutputStream(connection);
            input = getInputStream(connection);

            String message = input.readLine();
            // Will stop listening to messages when client sends T|
            while(this.keepRunningClient) {
                newMessage = processClientMessage(message);
                if(Objects.equals(message, "T|")){
                    sendMessage("0|OK", output);
                    this.keepRunningClient = false; // while loop ends
                    break; // break out of loop so that the rest does not finish
                }
                displayMessage(newMessage);
                sendMessage(newMessage, output);
                message = input.readLine();

            }


        }catch(IOException | InterruptedException e){
            //    e.printStackTrace();

        }
        finally {
            try {
                System.out.println("Terminating connection");
                closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String processClientMessage(String message) throws IOException, InterruptedException{
        // Build new tournament here to run all processes depending on what is selected
        // Tournament command = new Tournament();
        String newMessage;
        if(Objects.equals(message, "TERMINATE|")){
            newMessage = "TERMINATE";
            Server.shutdown();
        }
        else newMessage = message.toUpperCase();

        return newMessage;

    }
    private PrintWriter getOutputStream(Socket socket) throws IOException {
        return new PrintWriter(socket.getOutputStream(), true);

    }

    private BufferedReader getInputStream(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    // Closing connections and catching exceptions
    private void closeConnection(){
        try{this.input.close();} catch(IOException|NullPointerException e){e.printStackTrace();}
        try{this.output.close();} catch(NullPointerException e){e.printStackTrace();}
        try{this.connection.close();} catch(IOException|NullPointerException e){e.printStackTrace();}
    }

    private void sendMessage(String message, PrintWriter output){output.println(message);}

    private void displayMessage(String message){System.out.println(message);}

    // forceShutdown is being called from Server to shutdown each clientworker connection
    protected void forceShutdown() throws IOException {
        this.keepRunningClient = false;
        connection.close();
    }

}
