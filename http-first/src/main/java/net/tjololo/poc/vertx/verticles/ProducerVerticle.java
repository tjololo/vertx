package net.tjololo.poc.vertx.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Created by tjololo on 24/10/16.
 */
public class ProducerVerticle extends AbstractVerticle {
    @Override
    public void start(Future future) {
        vertx.eventBus().publish("events", "message1");
        vertx.eventBus().send("events", "message 2");
        vertx.eventBus().send("events", "message 3");
        vertx.eventBus().send("events", "message 4");
    }
}
