package com.example.camel3;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@CamelSpringBootTest
class ExceptionThrowingRouteTest {


    @Autowired
    private ProducerTemplate template;

    @EndpointInject("mock:received")
    private MockEndpoint mock;

    @Test
    public void exceptionTest(){
        template.sendBody("direct:start-exception","");
    }

}