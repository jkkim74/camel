package com.example.camel3;

import org.apache.camel.builder.RouteBuilder;

public class GreetingFileRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start")
                .routeId("greeting-route")
                .setBody(constant("Hello jack Camel is difficult"))
                .to("file:output");
    }
}
