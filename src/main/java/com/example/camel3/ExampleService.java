package com.example.camel3;


/**
 * a Mock class to show how some other layer
 * (a persistence layer, for instance)
 * could be used insida a Camel
 *
 */
public class ExampleService {

    public static void example(MyBean bodyIn) {
        bodyIn.setName( "Hello, " + bodyIn.getName() );
        bodyIn.setId(bodyIn.getId()*10);
    }
}
