package no.kristiania.pgr200.jlw;

import java.io.IOException;

public interface HttpServerResponseBuilderFactoryInterface {

    HttpServerResponseBuilder createBuilder(String path) throws IOException;
}
