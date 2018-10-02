package no.kristiania.pgr200.jlw.httpserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServerListener {

    private int port;
    private int actualPort;

    public HttpServerListener(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(0);
        this.actualPort = serverSocket.getLocalPort();
        new Thread(() ->  serverThread(serverSocket)).start();
    }

    public void serverThread(ServerSocket serverSocket) {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                Thread t = new HttpServerReqestListener(clientSocket);
                t.start();
            } catch (IOException e) {
                System.out.println("ZOMG SERVER WENT SPLODE");
                e.printStackTrace();
            }
        }
    }

    public int getPort() {
        return actualPort;
    }

    public static void main(String[] args) {
        HttpServerListener server = new HttpServerListener(0);
        try {
            server.start();
        } catch (IOException e) {
            System.out.println("Error starting server.");
            e.printStackTrace();
        }
    }
}
