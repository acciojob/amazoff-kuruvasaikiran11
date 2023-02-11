package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

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

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        return "";
    }

    public List<String> getOrdersByPartnerId(String partnerId) {
        List<String> orders = new ArrayList<>();
        return orders;
    }

    public Integer getOrderCountByPartnerId(String partnerId) {
        if(deliveryPartnerMap.containsKey(partnerId))
            return 1;
        else return 0;
    }

    public Integer getCountOfUnassignedOrders() {
        return 0;
    }

    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String partnerId) {
        return 1;
    }
}
