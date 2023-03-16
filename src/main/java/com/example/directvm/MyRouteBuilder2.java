package com.example.directvm;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder2 extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct-vm:process")
                .log("${body}");
    }
}
