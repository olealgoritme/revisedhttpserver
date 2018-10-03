package no.kristiania.pgr200.jlw.httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import no.kristiania.pgr200.jlw.entities.Client;


public class HttpServerListener extends Thread {

    private int port;
    private int actualPort;

    //private static Logger LOGGER = LoggerFactory.getLogger(HttpServerListener.class);

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private HttpServerCallback listener;

    public HttpServerListener(int port) {
        this.port = port;
    }

    private void setCallback(HttpServerCallback listener) {
        this.listener = listener;
    }

    private void setExceptionHandler() {
        // empty still
        // TODO: create global/internal exception handler with singleton class (getInstance() returns singleton)
    }

    @Override
    public void run() {

        try {
             serverSocket = new ServerSocket(this.port);
            this.actualPort = serverSocket.getLocalPort();
        } catch (IOException e) {
            // send to handler
            System.out.println("Error opening Server socket on port " + this.port);
            System.exit(0);
        } finally {
      
        // correct place to listen for client connections, after we have exhausted
        // all possible errors.

        //LOGGER.info("Server started!");
        System.out.println("Server started. Listening on port " + this.port);
        
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                HttpServerRequestHandler requestHandler = new HttpServerRequestHandler(clientSocket);
                requestHandler.start();
                // -- here one could pass a client object to the subscribers (listener var) (this will be called in the main() method, when client connects)
                // -- should also pass the client to the request handler singleton thread
                // -- nothing happens now
                // TODO: Implement request handler singleton thread
                // -- do not instantiate threads per connect, stupid idea.
                listener.onClientConnected(new Client());
            } catch (IOException e) {
                System.out.println("ZOMG SERVER WENT SPLODE");
                e.printStackTrace();
            }
        }

        }

    }

    public int getPort() {
        return actualPort;
    }

    public static void main(String[] args) {



        // TODO: revise where to handle requests (in callback or in loop)

        HttpServerListener server = new HttpServerListener(8000);
        
        server.setCallback(new HttpServerCallback() {
            
            @Override 
            public void onClientConnected(Client client) {

              System.out.println("Client connected!");
            }
            
        });
        

        server.start();

    }
}
