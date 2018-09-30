package no.kristiania.pgr200.jlw;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class HttpServerParserFactory implements HttpServerParserFactoryInterface{

    public HttpServerRequest request;
    public String requestType;

    public HttpServerParserFactory(HttpServerRequest request){
        this.request = request;
        int delimiterPos = request.getRequestBody().get(0).indexOf(" ");
        try{
            requestType = request.getRequestBody().get(0).substring(0, delimiterPos);
        } catch(IndexOutOfBoundsException e){
            System.out.println("Error retrieving request type.");
        }
    }

    public HttpServerParser createParser(String requestType) {
        switch(requestType){
            case "GET":
                return new HttpServerParserGET(request);
            default:
                throw new IllegalArgumentException("Invalid HTTP method");
       }
    }

    public String getRequestType(){
        return requestType;
    }
}
