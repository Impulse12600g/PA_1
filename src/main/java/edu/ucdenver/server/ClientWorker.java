package edu.ucdenver.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

/**
 * <p>
 * ClientWorker class to handle each connected client
 * </p>
 */
public class ClientWorker implements Runnable {

    /**
     * <p>
     * server object from class Server. Used to connect the client to the server
     * </p>
     */
    private final Server server;

    /**
     * <p>
     * connection variable used to build the socket for the client
     * </p>
     */
    private final Socket connection;

    /**
     * <p>
     * keepRunningClient boolean used to control the client looping process
     * </p>
     */
    private Boolean keepRunningClient;

    /**
     * <p>
     * output PrintWriter variable for outputting
     * </p>
     */
    private PrintWriter output;

    /**
     * <p>
     * input BufferedReader variable for reading inputs
     * </p>
     */
    private BufferedReader input;

    /**
     * <p>
     * ClientWorker constructor used to connect the client to the server given.
     * </p>
     * @param server object of class Server to tie the server to the client
     * @param socket variable to bind the client connection to
     */
    public ClientWorker(Server server, Socket socket){
        this.connection = socket;
        this.server = server;
        this.keepRunningClient = true;
    }

    /**
     * <p>
     * run method for ClientWorker. Each time a client worker is made, we will try to bind the input and output
     * to the connection. Then, we start reading from the client. While it is running, we will process all messages.
     * Currently, this template is from hw4, and not expanded upon because all of our app communication is
     * being handled straight from the ServerApplication.
     * Otherwise, we would process each message (an app button click for example) then continue until the stop server
     * button or "exit" button was pressed.
     * </p>
     */
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

    /**
     * <p>
     * processClientMessage method. This would of been the main control center for the entire project. We instead
     * used the ServerApplication.
     * Each time a message was received, we would check it, and run the method calls needed to fill out the request.
     * We would process each method, then return any new message needed.
     * </p>
     * @param message that this method would be processing and sending calls based off of
     * @return newMessage that holds something needing to be sent out from the client worker.
     */
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

    /**
     * <p>
     * getOutputStream print writer method that will create and return a new print writer that is
     * connected to the socket output stream. Setting auto flush to true.
     * </p>
     * @param socket for connecting the print writer
     * @return describe what the method returns, if anything
     */
    private PrintWriter getOutputStream(Socket socket) throws IOException {
        return new PrintWriter(socket.getOutputStream(), true);

    }

    /**
     * <p>
     * getInputStream buffered reader method that will create and return a new buffered reader made from
     * the input stream reader of the socket's input stream.
     * </p>
     * @param socket that is used to connect the input stream
     * @return BufferedReader
     */
    private BufferedReader getInputStream(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /**
     * <p>
     * closeConnection method that will try to close the input, output, and connection.
     * </p>
     */
    private void closeConnection(){
        try{this.input.close();} catch(IOException|NullPointerException e){e.printStackTrace();}
        try{this.output.close();} catch(NullPointerException e){e.printStackTrace();}
        try{this.connection.close();} catch(IOException|NullPointerException e){e.printStackTrace();}
    }

    /**
     * <p>
     * sendMessage method that will use the clientWorker output to send a message when needed
     * </p>
     * @param message that needs to be sent
     * @param output that represents the connection we are sending the message to
     */
    private void sendMessage(String message, PrintWriter output){output.println(message);}

    /**
     * <p>
     * displayMessage method that will print out any needed message.
     * Mostly used for testing and confirming connections.
     * </p>
     * @param message that needs to be displayed
     */
    private void displayMessage(String message){System.out.println(message);}

    /**
     * <p>
     * forceShutdown method that is being used along with the server shutdown method.
     * Will, in this case, just call for the connection to close. Any other shutdowns will happen
     * if the client worker receives a message saying to terminate the connection.
     * </p>
     * @throws IOException if this fails
     */
    protected void forceShutdown() throws IOException {
        this.keepRunningClient = false;
        connection.close();
    }
}
