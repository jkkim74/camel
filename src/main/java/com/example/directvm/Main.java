package com.example.directvm;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {
    public static void main(String[] args) throws Exception {
        CamelContext first = new DefaultCamelContext();
        first.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("timer:start").setBody(simple("Hello, World")).to("direct-vm:test");
            }
        });

        CamelContext second = new DefaultCamelContext();
        second.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct-vm:test").log("Message received ${body}");
            }
        });

        first.start();
        second.start();

        Thread.sleep(100000);

        first.stop();
        second.stop();
    }
}
