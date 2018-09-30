package no.kristiania.pgr200.jlw;

import java.io.IOException;

public class HttpServerParserPOST extends HttpServerParser {

    StringBuilder body;

    public HttpServerParserPOST(HttpServerRequest request){
        super(request);
        this.request = request;
        body = new StringBuilder();
    }

    @Override
    public void parse() throws IOException {
        parseRequestLine();
        for(String line : request.getRequestBody().subList(1, request.getRequestBody().size())){
            parseHeaderLines(line);
        }
        request.setBody(body.toString());
    }

    @Override
    void parseHeaderLines(String line) throws IOException {
        StringBuilder body = new StringBuilder();
        if(line.contains(":")){
            int colonPos = line.indexOf(":");
            request.setHeader(line.substring(0, colonPos), line.substring(colonPos+1));
        } else {
            if(!line.isEmpty()){
                body.append(line);
            }
        }
    }
}
