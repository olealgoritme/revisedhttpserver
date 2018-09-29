package no.kristiania.pgr200.jlw;

public abstract class HttpServerResponseBuilder {
    protected HttpServerRequest request;
    protected HttpServerResponse response;

    public void setStatusLine(int statusCode){
        response.setStatusLine(request.getHttpVersion() + " " + statusCode + " " + HttpServerStatusMessages.getStatusMessage(statusCode));
    }

    abstract void createResponse();

    abstract void setHeaderLines();

    abstract void setBody();
}
