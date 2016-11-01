package net.tjololo.poc.vertx;

import io.vertx.core.Vertx;
import net.tjololo.poc.vertx.verticles.ConsumerVerticle;
import net.tjololo.poc.vertx.verticles.HttpVerticle;
import net.tjololo.poc.vertx.verticles.ProducerVerticle;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new ConsumerVerticle("C1"), asyncCallback -> {
            if (asyncCallback.failed()) {
                System.out.println("Failed");
                System.exit(1);
            } else {
                System.out.println("Verticle deployed");
            }
        });
        vertx.deployVerticle(new ConsumerVerticle("C2"));
        vertx.deployVerticle(new HttpVerticle());
        Thread.sleep(10000);
        vertx.deployVerticle(new ProducerVerticle());
    }
}
