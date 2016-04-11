package com.larscode.vertxtest;

import io.vertx.core.Vertx;

public class Main {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        /* Deploy verticle by instantiating it */
        // vertx.deployVerticle(new SomeVerticle());
        /* Deploy verticle by specifying it's full class path name */
        // vertx.deployVerticle("com.larscode.vertxtest.SomeVerticle");

        /* Deploy verticle allows you to specify a callback that is run after
         * the verticle has been deployed. In the example below we undeploy the
          * same verticle right after it has been deployed.*/
        // In Java 6 you would use an anonymous inner class to write the callback. Very verbose.
//         SomeVerticle someVerticle = new SomeVerticle();
//
//        vertx.deployVerticle(someVerticle, new Handler<AsyncResult<String>>() {
//            @Override
//            public void handle(AsyncResult<String> event) {
//                if (event.succeeded()) {
//                    vertx.undeploy(someVerticle.deploymentID());
//                } else if (event.failed()) {
//                    throw new RuntimeException("Failed to deploy", event.cause());
//                }
//            }
//        });

        //In Java 8 you can use a lambda instead. Vertx makes frequent use of lambdas.
//        SomeVerticle someVerticle = new SomeVerticle();
//        vertx.deployVerticle(someVerticle, event -> {
//            if (event.succeeded()) {
//                vertx.undeploy(someVerticle.deploymentID());
//            } else if (event.failed()) {
//                throw new RuntimeException("Failed to deploy", event.cause());
//            }
//        });

        //In this code we deploy one verticle, wait deployment to be done and then deploy the other.
        //This is useful when one verticle is dependent on the other being deployed.
        vertx.deployVerticle(new OtherVerticle(), result -> vertx.deployVerticle(new SomeVerticle()));


    }
}
