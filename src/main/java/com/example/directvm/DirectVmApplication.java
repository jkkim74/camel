package com.example.directvm;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.concurrent.TimeUnit;

public class DirectVmApplication {

    public static void main(String[] args) throws Exception{
       CamelContext context = new DefaultCamelContext();
       context.addRoutes(new MyRouteBuilder1());
       CamelContext context2 = new DefaultCamelContext();
        context2.addRoutes(new MyRouteBuilder2());

       context.start();
        context2.start();

        TimeUnit.MINUTES.sleep(1);

        context.stop();
        context2.stop();
    }
}
