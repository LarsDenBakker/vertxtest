package com.larscode.vertxtest;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

public class SomeVerticle extends AbstractVerticle {

    public static final String CHANNEL = "taf.mijnKanaal";

    //Called on deploy
    @Override
    public void start() throws Exception {
        System.out.println("Some Verticle Started");
        JsonObject json = new JsonObject()
                .put("key", "value")
                .put("msg", "hoi!");
        vertx.eventBus().publish(CHANNEL, json);
    }

}
