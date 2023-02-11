package com.driver;

import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {

    Map<String, Order> orderMap;
    Map<String, Integer> deliveryPartnerMap;

    OrderRepository(){
        orderMap = new HashMap<>();
        deliveryPartnerMap = new HashMap<>();
    }


    public void addOrder(Order order) {
        String id = order.getId();
        orderMap.put(id, order);
    }

    public void addPartner(String partnerId) {
        deliveryPartnerMap.put(partnerId, deliveryPartnerMap.getOrDefault(partnerId, 0) + 1);
    }

    public Order getOrder(String orderId) {
        if(orderId == null) return null;

        if(orderMap.containsKey(orderId)) return orderMap.get(orderId);
        else return null;
    }


    public DeliveryPartner getPartner(String partnerId) {
        DeliveryPartner deliveryPartner = new DeliveryPartner(partnerId);

        int orders = deliveryPartnerMap.get(partnerId);
        deliveryPartner.setNumberOfOrders(orders);
        return deliveryPartner;
    }

    public List<String> getAllOrders() {
        List<String> orders = new LinkedList<>();
        for (String order : orderMap.keySet()) {
            orders.add(order);
        }
        return orders;
    }
}
