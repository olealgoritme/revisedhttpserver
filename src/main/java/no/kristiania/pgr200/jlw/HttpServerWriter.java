package no.kristiania.pgr200.jlw;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class HttpServerWriter {

    private OutputStream output;
    private HttpServerResponse response;

    public HttpServerWriter(OutputStream output, HttpServerResponse response) {
        this.output = output;
        this.response = response;
    }

    public void write() throws IOException {
        output.write((response.getStatusLine() + "\r\n").getBytes());
        for(String header: response.getHeaders()){
            output.write((header + "\r\n").getBytes());
        }
        if(response.getBody() != null){
            output.write(("\r\n").getBytes());
            output.write((response.getBody() + "\r\n").getBytes());
        }
    }
}
