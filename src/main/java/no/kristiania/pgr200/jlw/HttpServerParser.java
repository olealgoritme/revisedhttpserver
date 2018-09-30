package no.kristiania.pgr200.jlw;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public abstract class HttpServerParser {

    public HttpServerRequest request;

    public HttpServerParser(HttpServerRequest request){
        this.request = request;
    }

    public void parseRequestLine() throws IOException{
            try {
                String requestLine[] = request.getRequestBody().get(0).split(" ");
                request.setHttpMethod(requestLine[0]);
                request.setURL(requestLine[1].substring(1));
                request.setHttpVersion(requestLine[2]);
                parseParameters(parsePath());
            } catch(IndexOutOfBoundsException e){
                System.out.println("Index out of bounds on parseRequestLine in HttpServerParser.");
            } catch(NullPointerException e){
                System.out.println("Null pointer exception on parseRequestLine in HttpServerParser.");
            }
    }

    public String parsePath() {
        String uri[] = request.getURL().split("[?]");
        request.setPath(uri[0]);
        if(uri.length > 1) {
            return uri[1];
        } else{
            return "";
        }
    }

    public void parseParameters(String paramString) {
        if(!paramString.isEmpty()) {
            String queryParams[] = paramString.split("&");
            for (String param : queryParams) {
                int delimiterPos = param.indexOf("=");
                try {
                    request.setParameter(param.substring(0, delimiterPos), URLDecoder.decode(param.substring(delimiterPos + 1), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    System.out.println("Error parsing parameters");
                }
            }
        }
    }

    abstract void parse() throws IOException;

    abstract void parseHeaderLines(String line) throws IOException;
}
