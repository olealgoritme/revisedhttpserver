package no.kristiania.pgr200.jlw;

public interface HttpServerParserFactoryInterface {


    HttpServerParser createParser(String requestType);

    String getRequestType();
}
