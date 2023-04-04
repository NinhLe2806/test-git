package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Value("${order.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Order addOrder(Order ord) {
        ord = orderRepository.save(ord);

        ObjectMapper om=new ObjectMapper();

        String message= null;
        try {
            message = om.writeValueAsString(ord);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send(topicName,message);

        return ord;
    }

    @Override
    public Order updateOrder(long id, Order ord) {
        return null;
    }

    @Override
    public boolean deleteOrder(long id) {
        return false;
    }

    @Override
    public List<Order> getListOrder() {
        return null;
    }

    @Override
    public Order getOrder(long id) {
        return null;
    }
}
