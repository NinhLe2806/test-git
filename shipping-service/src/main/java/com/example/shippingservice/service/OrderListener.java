package com.example.shippingservice.service;

import com.example.shippingservice.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderListener {

    ObjectMapper om = new ObjectMapper();

    @KafkaListener(topics = "order-topic", groupId = "groupId")
    public void processOrder(String message){
        System.out.println("Received Message: " + message);

        try{
            Order order = om.readValue(message,Order.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
