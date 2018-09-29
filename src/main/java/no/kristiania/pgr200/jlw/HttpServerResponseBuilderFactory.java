package no.kristiania.pgr200.jlw;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.IOException;

public class HttpServerResponseBuilderFactory implements HttpServerResponseBuilderFactoryInterface{

    private HttpServerResponse response;

    public HttpServerResponseBuilderFactory(HttpServerResponse response){
        this.response = response;
    }

    public HttpServerResponseBuilder createBuilder(String path) throws IOException {
        switch(path){
            case "echo":
                return new HttpServerResponseBuilderEcho();
            default:
                return new HttpServerResponseBuilderURL();
        }
    }
}
