package com.example.orderservice.service;

import com.example.orderservice.model.Order;

import java.util.List;

public interface OrderService {
    public Order addOrder(Order ord);

    public Order updateOrder(long id, Order ord);

    public boolean deleteOrder(long id);

    public List<Order> getListOrder();

    public Order getOrder(long id);

}
