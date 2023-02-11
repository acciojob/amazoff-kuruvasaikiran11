package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    public void addPartner(String partnerId) {
        orderRepository.addPartner(partnerId);
    }

    public Order getOrder(String orderId) {
        return orderRepository.getOrder(orderId);
    }

    public DeliveryPartner getPartner(String partnerId) {
        return orderRepository.getPartner(partnerId);
    }

    public List<String> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        return orderRepository.getLastDeliveryTimeByPartnerId(partnerId);
    }

    public List<String> getOrdersByPartnerId(String partnerId) {
        return orderRepository.getOrdersByPartnerId(partnerId);
    }

    public Integer getOrderCountByPartnerId(String partnerId) {
        return orderRepository.getOrderCountByPartnerId(partnerId);
    }

    public Integer getCountOfUnassignedOrders() {
        return orderRepository.getCountOfUnassignedOrders();
    }

    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String partnerId) {
        return orderRepository.getOrdersLeftAfterGivenTimeByPartnerId(partnerId);
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        orderRepository.addOrderPartnerPair(orderId, partnerId);
    }
}
