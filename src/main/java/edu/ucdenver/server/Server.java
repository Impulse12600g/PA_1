package edu.ucdenver.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;

/**
 * <p>
 * Server class to set up multithreading functionality
 * </p>
 */
public class Server implements Runnable{

    /**
     * <p>
     * port variable for setting up the port each time a server is started
     * </p>
     */
    private final int port;
    /**
     * <p>
     * backlog variable to set up the backlog each time a server is started
     * </p>
     */
    private final int backlog;

    /**
     * <p>
     * connectionCounter variable to count the number of connections are made for the server
     * </p>
     */
    private int connectionCounter;

    /**
     * <p>
     * keepServerRunning boolean to make sure the loops can be controlled in the server execution
     * </p>
     */
    private static Boolean keepServerRunning;

    /**
     * <p>
     * executorService variable to execute client workers
     * </p>
     */
    static ExecutorService executorService;

    /**
     * <p>
     * clientWorkers array list to hold and control all connected client workers to the server
     * </p>
     */
    public static ArrayList<ClientWorker> clientWorkers = new ArrayList<>();

    /**
     * <p>
     * socketServer variable to create each time a server is started
     * </p>
     */
    private static ServerSocket socketServer;

    /**
     * <p>
     * Server constructor. Will build the server with given port and backlog.
     * Will also set the connectionCounter to 0, and turn on the keepServerRunning boolean.
     * We are initializing the socketServer here with a try and catch statement.
     * </p>
     * @param port representing the port to connect the server to
     * @param backlog representing the server's backlog
     */
    public Server(int port, int backlog){
        this.port = port;
        this.backlog = backlog;
        this.connectionCounter = 0;
        keepServerRunning = true;

        try{
            socketServer = new ServerSocket(this.port, this.backlog);
        } catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

    /**
     * <p>
     * waitForConnection method to try to accept the socketServer and send it back as a return.
     * Will add to the connectionCounter for the server.
     * </p>
     * @return connection for the server
     */
    private Socket waitForConnection() throws IOException {
        Socket connection = socketServer.accept();
        this.connectionCounter++;
        return connection;
    }

    /**
     * <p>
     * displayMessage method to send out a string when we need to communicate with a client.
     * Currently, with the way we built our app, this is just a print statement as a placeholder.
     * </p>
     * @param message that we are sending out attached to the string.
     */
    private void displayMessage(final String message){System.out.println("[SER]" + message);}

    /**
     * <p>
     * run method for the server.
     * This will start the thread pool for the client multithreading, then attempt to create a server socket.
     * Once a connection is made, we will loop, building a new client worker each time we loop (get new connection).
     * Once we are no longer getting the connection, we will terminate.
     */
    @Override
    public void run() {
        executorService = Executors.newCachedThreadPool();
        try{

            socketServer = new ServerSocket(this.port, this.backlog);

            while(keepServerRunning){
                try{
                    Socket connection = this.waitForConnection();
                    ClientWorker cw = new ClientWorker(this, connection);
                    executorService.execute(cw);
                    clientWorkers.add(cw); // Building client list
                    connectionCounter++;
                }
                catch (IOException ioe){
                    displayMessage("Server Terminated");
                    ioe.printStackTrace();
                    break;
                }
            }
        } catch(IOException ioe){
            displayMessage("Cannot open the server");
            ioe.printStackTrace();
        }
    }

    /**
     * <p>
     * shutdown method of the server. This works with the client worker class. Whenever it is called,
     * it will shutdown the executor service then try to close the server socket. Finally, it will
     * loop though each individual client worker and force shutdown each one of them.
     * </p>
     * @throws IOException is this fails
     */
    public static void shutdown() throws IOException {
        executorService.shutdown();
        try {
            keepServerRunning = false;
            socketServer.close();
        } catch (IOException e) {
            //  e.printStackTrace(); //ignoring errors
        } finally {
            for(ClientWorker worker: clientWorkers)
                worker.forceShutdown();


        }
    }
}
//