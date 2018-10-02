package no.kristiania.pgr200.jlw.httpserver;

import no.kristiania.pgr200.jlw.entities.Client;

public interface HttpServerCallback {

    void onClientConnected(Client client);
}
