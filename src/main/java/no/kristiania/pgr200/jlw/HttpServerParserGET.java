package no.kristiania.pgr200.jlw;

import java.io.IOException;
import java.io.InputStream;

public class HttpServerParserGET extends HttpServerParser{

    public HttpServerParserGET(HttpServerRequest request, InputStream input, String requestLine) {
        super(request, input, requestLine);
        this.request = request;
        this.input = input;
        this.requestLine = requestLine;
    }

    @Override
    public void parse() throws IOException{
        parseRequestLine();
        String line = HttpReadLine.readNextLine(input);
        while(!line.isEmpty()) {
            parseHeaderLines(line);
            line = HttpReadLine.readNextLine(input);
        }
    }

    @Override
    void parseHeaderLines(String line) throws IOException {
        int colonPos = line.indexOf(":");
        request.setHeader(line.substring(0, colonPos), line.substring(colonPos+1));
    }
}
