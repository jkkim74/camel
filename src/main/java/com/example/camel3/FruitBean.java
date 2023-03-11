package com.example.camel3;

import org.apache.camel.Exchange;

public class FruitBean {

    private FruitBean() {
    }

    public static boolean isApple(Exchange exchange){
        return "Apple".equals(exchange.getIn().getHeader("fruit"));
    }
}
