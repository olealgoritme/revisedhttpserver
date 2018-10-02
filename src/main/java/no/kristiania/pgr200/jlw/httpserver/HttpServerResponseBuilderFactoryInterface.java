package no.kristiania.pgr200.jlw.httpserver;

import java.io.IOException;

public interface HttpServerResponseBuilderFactoryInterface {

    HttpServerResponseBuilder createBuilder() throws IOException;
}
