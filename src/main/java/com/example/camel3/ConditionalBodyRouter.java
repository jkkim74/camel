package com.example.camel3;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConditionalBodyRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start-conditional")
                .routeId("conditional-body-route")
                .choice()
                    .when(body().contains("Baedung"))
                        .setBody(simple("GoodBye, Baedung"))
                        .to("mock:result-body")
                    .otherwise()
                        .to("mock:result-body")
                .end();

    }
}
