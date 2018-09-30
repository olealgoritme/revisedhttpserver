package no.kristiania.pgr200.jlw;

import java.io.IOException;

public interface HttpServerResponseBuilderFactoryInterface {

    HttpServerResponseBuilder createBuilder() throws IOException;
}
