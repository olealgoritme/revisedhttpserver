package no.kristiania.pgr200.jlw.httpserver;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import no.kristiania.pgr200.jlw.httpserver.HttpServerRequest;

public final class ResponseBuilder {

    private String statusLine;
    private List<String> headers = new ArrayList<>();
    private String body;

    private HttpServerRequest request;

    public ResponseBuilder() {
        // keep empty
    }

/*
     setStatusLine(int statusCode)
    

 createResponse();

 setHeaderLines();

    setBody();

*/
public Builder getBuilder(HttpServerRequest request) {
    this.request = request;
    return new Builder();
}


public class Builder {
/*
    public Builder setStatusLine(int statusCode) {
        this.statusLine = request.getHttpVersion() + " " + statusCode + " " + HttpServerStatusMessages.getStatusMessage(statusCode);
        return this;
    }

  //  public Builder setStatusLine(int statusCode) {}
  //      public Builder setStatusLine(int statusCode) {}
  //          public Builder setStatusLine(int statusCode) {}
}
*/
}
}