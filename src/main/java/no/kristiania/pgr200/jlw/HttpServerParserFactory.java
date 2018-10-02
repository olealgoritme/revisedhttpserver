package no.kristiania.pgr200.jlw;

import java.io.IOException;
import java.io.InputStream;

public class HttpServerParserFactory implements HttpServerParserFactoryInterface{

    public HttpServerRequest request;
    public String requestLine, httpRequestMethodType;
    public InputStream input;

    public HttpServerParserFactory(HttpServerRequest request, InputStream input){
        this.request = request;
        this.input = input;
        try {
            requestLine = HttpReadLine.readNextLine(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int delimiterPos = requestLine.indexOf(" ");
        try{
            httpRequestMethodType = requestLine.substring(0, delimiterPos);
        } catch(IndexOutOfBoundsException e){
            System.out.println("Error retrieving request type.");
        }
    }

    public HttpServerParser createParser(String httpRequestMethodType) {
        switch(httpRequestMethodType){
            case "GET":
                return new HttpServerParserGET(request, input, requestLine);
            case "POST":
                return new HttpServerParserPOST(request, input, requestLine);
            default:
                throw new IllegalArgumentException("Invalid HTTP method");
       }
    }

    public String getHttpRequestMethodType(){
        return httpRequestMethodType;
    }
}
