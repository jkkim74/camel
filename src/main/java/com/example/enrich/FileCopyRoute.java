package com.example.enrich;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.AggregationStrategy;

import com.google.gson.Gson;

public class FileCopyRoute extends RouteBuilder {
    private static Gson gson = new Gson();
    @Override
    public void configure() throws Exception {
        String customersFolder = "file:C:\\Users\\Public\\Customers?noop=true";
        String ordersFolder = "file:C:\\Users\\Public\\Orders?noop=true";
        String customerOrders = "file:C:\\Users\\Public\\CustomerOrders";

        AggregationStrategy aggregationStrategy = new AggregationStrategy(){

            @Override
            public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
                String orderInfo = oldExchange.getIn().getBody(String.class);
                String customerInfo = newExchange.getIn().getBody(String.class);

                System.out.println("\nOrder Information" + orderInfo);
                System.out.println("\nCustomer Information : " + customerInfo);

                Order order = gson.fromJson(orderInfo, Order.class);
                Customer customer = gson.fromJson(customerInfo, Customer.class);

                CustomerOrder custOrder = new CustomerOrder();
                custOrder.setOrder(order);
                custOrder.setCustomer(customer);

                String enrichedData = gson.toJson(custOrder);

                System.out.println("\nEnriched Information : " + enrichedData);

                oldExchange.getIn().setBody(enrichedData);

                return oldExchange;
            }
        };
        from(ordersFolder).pollEnrich(customersFolder, aggregationStrategy).to(customerOrders);
    }
}
