package net.tjololo.poc.vertx.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Created by tjololo on 22/10/16.
 */
public class ConsumerVerticle extends AbstractVerticle {

    private String name;

    public ConsumerVerticle(String name) {
        this.name = name;
    }

    @Override
    public void start(Future<Void> future) {
        System.out.println("Start " + name);
        vertx.eventBus().consumer("events", message -> {
            System.out.println(name + " verticle received message: " + message.body());
        });
        future.complete();
    }

    @Override
    public void stop(Future<Void> future) throws Exception {
        System.out.println("Stop");
    }

}
