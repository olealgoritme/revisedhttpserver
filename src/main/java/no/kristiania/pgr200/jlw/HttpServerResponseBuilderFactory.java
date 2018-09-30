package no.kristiania.pgr200.jlw;

import java.io.IOException;

public class HttpServerResponseBuilderFactory implements HttpServerResponseBuilderFactoryInterface{

    private HttpServerRequest request;
    private HttpServerResponse response;

    public HttpServerResponseBuilderFactory(HttpServerRequest request, HttpServerResponse response){
        this.request = request;
        this.response = response;
    }

    public HttpServerResponseBuilder createBuilder() throws IOException {
        switch(request.getPath()){
            case "echo":
                return new HttpServerResponseBuilderEcho(request, response);
            default:
                return new HttpServerResponseBuilderURL();
        }
    }
}
