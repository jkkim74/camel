package com.example.enrich;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.concurrent.TimeUnit;

public class EnrichApplication {
    public static void main(String args[]) throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new FileCopyRoute());

        context.start();

        TimeUnit.MINUTES.sleep(1);

        context.stop();
    }
}
