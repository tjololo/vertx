package net.tjololo.poc.vertx.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpServerResponse;

/**
 * Created by tjololo on 24/10/16.
 */
public class HttpVerticle extends AbstractVerticle {
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.createHttpServer().requestHandler(httpServerRequest -> {
            System.out.println("Ping");
            vertx.eventBus().send("events", "Received httpcall");
            HttpServerResponse response = httpServerRequest.response();
            vertx.eventBus().consumer("events", event -> {
                response.end("Hello from vert.x");
            });
        }).listen(9999);
    }
}
