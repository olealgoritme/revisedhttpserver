package no.kristiania.pgr200.jlw;

import java.io.IOException;
import java.io.InputStream;

public class HttpServerParserFactory implements HttpServerParserFactoryInterface{

    public InputStream input;
    public HttpServerRequest request;
    public String requestType, firstLine;

    public HttpServerParserFactory(InputStream input){
        this.input = input;
        this.request = request;
        try {
            firstLine = readNextLine(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int delimiterPos = firstLine.indexOf(" ");
        try{
            requestType = firstLine.substring(0, delimiterPos);
        } catch(IndexOutOfBoundsException e){
            System.out.println("Error retrieving request type.");
        }
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

    public static String readNextLine(InputStream input) throws IOException {
        StringBuilder nextLine = new StringBuilder();
        int c;
        while ((c = input.read()) != -1) {
            if (c == '\r') {
                input.read();
                break;
            }
            nextLine.append((char) c);
        }
        return nextLine.toString();
    }
}
