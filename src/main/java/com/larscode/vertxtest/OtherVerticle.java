package com.larscode.vertxtest;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

public class OtherVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        System.out.println("Other Verticle Started");
        vertx.eventBus().<JsonObject>consumer(SomeVerticle.CHANNEL, message -> {
            JsonObject object = message.body();
            System.out.println("OtherVerticle received a msg: " + object);
        });
    }

}
