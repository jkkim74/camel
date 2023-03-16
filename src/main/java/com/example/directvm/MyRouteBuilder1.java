package com.example.directvm;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder1 extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start")
                .setBody(simple("Hello, World!"))
                .to("direct-vm:process");
    }
}
