package com.example.camel3;

import org.apache.camel.builder.RouteBuilder;

public class ConditionalHeaderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:conditional-header")
                .routeId("conditional-header-route")
                .choice()
                    .when(header("fruit").isEqualTo("Apple"))
                        .setHeader("favourite",simple("Apples"))
                        .to("mock:result")
                    .otherwise()
                        .setHeader("favourite",header("fruit"))
                        .to("mock:result")
                .end();

    }
}
