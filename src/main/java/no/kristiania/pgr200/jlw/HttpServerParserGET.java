package no.kristiania.pgr200.jlw;

import java.io.IOException;
import java.io.InputStream;

public class HttpServerParserGET extends HttpServerParser{

    public HttpServerParserGET(HttpServerRequest request){
        super(request);
        this.request = request;
    }

    @Override
    public void parse() throws IOException{
        parseRequestLine();
        for(String line : request.getRequestBody().subList(1, request.getRequestBody().size())){
            parseHeaderLines(line);
        }
    }

    @Override
    void parseHeaderLines(String line) throws IOException {
        int colonPos = line.indexOf(":");
        request.setHeader(line.substring(0, colonPos), line.substring(colonPos+1));
    }
}
