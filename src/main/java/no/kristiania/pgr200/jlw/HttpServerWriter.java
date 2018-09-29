package no.kristiania.pgr200.jlw;

import java.io.OutputStream;
import java.net.Socket;

public class HttpServerWriter {

    private Socket clientSocket;
    private OutputStream output;

    public HttpServerWriter(OutputStream output, Socket clientSocket) {
        this.output = output;
        this.clientSocket = clientSocket;
    }

    public void write() {

    }
}
