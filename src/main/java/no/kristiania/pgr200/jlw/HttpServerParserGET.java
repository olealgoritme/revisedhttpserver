package no.kristiania.pgr200.jlw;

import java.io.IOException;
import java.io.InputStream;

public class HttpServerParserGET extends HttpServerParser{

    public HttpServerParserGET(InputStream input, HttpServerRequest request){
        this.input = input;
        this.request = request;
    }

    @Override
    public void parse() throws IOException{
        parseRequestLine();
        String line = readNextLine(input);
        while (!line.isEmpty()) {
            parseHeaderLines(line);
            line = readNextLine(input);
        }
    }

    @Override
    void parseHeaderLines(String line) throws IOException {
        int colonPos = line.indexOf(":");
        request.setHeader(line.substring(0, colonPos), line.substring(colonPos+1));
    }
}
