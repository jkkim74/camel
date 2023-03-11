package com.example.camel3;

import org.apache.camel.builder.RouteBuilder;

public class Timer extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("timer:foo?period=1000").log("Hello World");

    }
}
