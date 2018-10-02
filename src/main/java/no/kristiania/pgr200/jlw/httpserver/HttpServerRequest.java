package no.kristiania.pgr200.jlw.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HttpServerRequest {

    private InputStream input;
    private String HttpMethod, HttpVersion, URL, body, path;
    private HashMap<String, String> headers, parameters;


    public HttpServerRequest() {
        headers = new HashMap<>();
        parameters = new HashMap<>();
    }



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

    public String getHeader(String key) {
        return headers.get(key);
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
