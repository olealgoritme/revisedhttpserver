package no.kristiania.pgr200.jlw.httpserver;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class HttpServerResponse {

    private String statusLine;
    private List<String> headers;
    private String body;

    public HttpServerResponse(){
        headers = new ArrayList<>();
    }

    public String getStatusLine() {
        return statusLine;
    }

    public void setStatusLine(String statusLine) {
        this.statusLine = statusLine;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(String header) {
        headers.add(header);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
