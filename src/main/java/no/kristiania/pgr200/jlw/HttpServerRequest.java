package no.kristiania.pgr200.jlw;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HttpServerRequest {

    private InputStream input;
    private String HttpMethod, HttpVersion, URL, body, path;
    private HashMap<String, String> headers, parameters;
    private List<String> requestBody;

    public HttpServerRequest(InputStream input) {
        this.input = input;
        requestBody = new ArrayList<>();
        headers = new HashMap<>();
        parameters = new HashMap<>();
        populateRequestBody(input);
    }

    private void populateRequestBody(InputStream input) {
        try {
            String line = readNextLine(input);
            while (!line.isEmpty()) {
                requestBody.add(line);
                line = readNextLine(input);
            }
        } catch(IOException ioe){
            System.out.println("Error reading input stream.");
        }
    }

    public List<String> getRequestBody(){
        return requestBody;
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

    private String readNextLine(InputStream input) throws IOException {
        StringBuilder currentLine = new StringBuilder();
        int c;
        while ((c = input.read()) != -1) {
            if (c == '\r') {
                input.mark(1);
                c = input.read();
                if (c != '\n') {
                    input.reset();
                }
                break;
            }
            currentLine.append((char)c);
        }
        return currentLine.toString();
    }
}
