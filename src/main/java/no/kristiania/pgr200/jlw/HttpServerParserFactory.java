package no.kristiania.pgr200.jlw;

import java.io.IOException;
import java.io.InputStream;

public class HttpServerParserFactory implements HttpServerParserFactoryInterface{

    public InputStream input;
    public HttpServerRequest request;
    public String requestType;

    public HttpServerParserFactory(InputStream input){
        this.input = input;
        this.request = request;
        int delimiterPos = input.toString().indexOf(" ");
        requestType = input.toString().substring(0, delimiterPos);
    }

    public HttpServerParser createParser(String requestType) {
        switch(requestType){
            case "GET":
                return new HttpServerParserGET(input, request);
            default:
                throw new IllegalArgumentException("Invalid HTTP method");
       }
    }

    public String getRequestType(){
        return requestType;
    }
}
