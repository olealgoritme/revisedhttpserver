package no.kristiania.pgr200.jlw;

import java.io.IOException;
import java.io.InputStream;

public class HttpServerParserPOST extends HttpServerParser {

    StringBuilder body;

    public HttpServerParserPOST(HttpServerRequest request, InputStream input, String requestLine){
        super(request, input, requestLine);
        this.request = request;
        this.input = input;
        this.requestLine = requestLine;
    }

    @Override
    public void parse() throws IOException {
        parseRequestLine();
        String line = HttpReadLine.readNextLine(input);
        while(!line.isEmpty()) {
            parseHeaderLines(line);
            line = HttpReadLine.readNextLine(input);
        }
        parseBody();
    }

    @Override
    public void parseHeaderLines(String line) throws IOException {
        int colonPos = line.indexOf(":");
        request.setHeader(line.substring(0, colonPos), line.substring(colonPos+1));
        request.setParameter(line.substring(0, colonPos), line.substring(colonPos+1));
    }

    public void parseBody(){
        StringBuilder body = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(request.getParameter("Content-Length").trim()); i++) {
            try {
                int c = input.read();
                body.append((char) c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        request.setBody(body.toString());
    }
}
