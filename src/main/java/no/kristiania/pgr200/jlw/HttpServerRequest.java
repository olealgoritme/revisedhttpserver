package no.kristiania.pgr200.jlw;

import java.io.InputStream;
import java.util.HashMap;

public class HttpServerRequest {

    private InputStream input;
    private String HttpMethod, HttpVersion, URL, body, path;
    private HashMap<String, String> headers, parameters;

    /*public HttpServerRequest(InputStream input){
        this.input = input;
    }*/

    public String getHttpMethod() {
        return HttpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.HttpMethod = httpMethod;
    }

    public String getHttpVersion() {
        return HttpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.HttpVersion = httpVersion;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public HashMap<String, String> getHeader() {
        return headers;
    }

    public void setHeader(String header, String value) {
        headers.put(header, value);
    }

    public void setPath(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public HashMap<String, String> getAllParameters(){
        return parameters;
    }

    public String getParameter(String param){
        return parameters.get(param);
    }

    public void setParameter(String param, String value){
        parameters.put(param, value);
    }
}
