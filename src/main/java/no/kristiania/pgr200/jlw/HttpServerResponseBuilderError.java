package no.kristiania.pgr200.jlw;

import java.time.LocalDate;

public class HttpServerResponseBuilderError extends HttpServerResponseBuilder {
    LocalDate date = LocalDate.now();

    public HttpServerResponseBuilderError(HttpServerRequest request, HttpServerResponse response){
        this.request = request;
        this.response = response;
    }

    @Override
    public void createResponse(){
        this.setStatusLine(Integer.parseInt((request.getParameter("status"))));
    }

    @Override
    public void setHeaderLines() {
        response.setHeaders("X-Server-Name: Re-re-re-revised Web Server");
        response.setHeaders("Date: " + date);
        response.setHeaders("Connection: close");
        response.setHeaders("Content-Type : text/plain");
        response.setHeaders("Content-Length: " + response.getBody().length());
    }

    @Override
    public void setBody() {
            response.setBody("");
    }
}