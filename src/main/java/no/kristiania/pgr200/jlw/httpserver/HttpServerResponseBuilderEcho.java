package no.kristiania.pgr200.jlw.httpserver;

import java.time.LocalDate;

public class HttpServerResponseBuilderEcho extends HttpServerResponseBuilder{

    LocalDate date = LocalDate.now();

    public HttpServerResponseBuilderEcho(HttpServerRequest request, HttpServerResponse response){
        this.request = request;
        this.response = response;
    }

    @Override
    public void createResponse(){
        if(request.getParameter("status") != null) {
            this.setStatusLine(Integer.parseInt((request.getParameter("status"))));
        } else{
            this.setStatusLine(200);
        }
        setBody();
        setHeaderLines();
    }

    @Override
    public void setHeaderLines() {
        response.setHeaders("X-Server-Name: Re-re-re-revised Web Server");
        response.setHeaders("Date: " + date);
        response.setHeaders("Connection: close");
        response.setHeaders("Content-Type : text/plain");
        response.setHeaders("Content-Length: " + response.getBody().length());
        String location = request.getParameter("Location");
        if(location != null){
            response.setHeaders("Location: " + location);
        }
    }

    @Override
    public void setBody() {
        response.setBody("pong");
    }
}
