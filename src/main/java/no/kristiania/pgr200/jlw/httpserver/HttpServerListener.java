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
    private HttpServerCallback callback;

    public HttpServerListener(int port) {
        this.port = port;
    }

    private void setCallback(HttpServerCallback callback) {
        this.callback = callback;
    }

    private void setExceptionHandler() {
        // empty still
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
      
        //LOGGER.info("Server started!");
        System.out.println("Server started. Listening on port " + this.port);
        
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                // -- here one could pass a client object to the subscribers (this will be called in the main() method, when client connects)
                // -- should also pass the client to the request handler singleton thread
                // -- nothing happens now
                // TODO: Implement request handler singleton thread
                callback.onClientConnected(new Client());
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
        HttpServerListener server = new HttpServerListener(8000);
        server.setCallback(new HttpServerCallback() {
            
            @Override 
            public void onClientConnected(Client client) {
               // LOGGER.info("Client connected!");
               System.out.println("Client connected!");
            }
            
        
        });
        server.start();

    }
}
