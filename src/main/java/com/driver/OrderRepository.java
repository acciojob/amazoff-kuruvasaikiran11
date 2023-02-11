package com.driver;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {

    private Map<String, Order> orderMap;
    private Map<String, DeliveryPartner> deliveryPartnerMap;
    private Map<String, List<String>> orderPartnerMap;
    private Map<String, String> lastDeliveryTimeByPartnerMap;

    private Map<String, Integer> orderCountByPartnerMap;


    DeliveryPartner count = new DeliveryPartner();
    OrderRepository(){
        this.orderMap = new HashMap<>();
        this.deliveryPartnerMap = new HashMap<>();
        this.orderPartnerMap = new HashMap<>();
        this.orderCountByPartnerMap = new HashMap<>();
        this.lastDeliveryTimeByPartnerMap = new HashMap<>();
    }


    public void addOrder(Order order) {
        String id = order.getId();
        orderMap.put(id, order);
    }

    public void addPartner(String partnerId) {
        DeliveryPartner deliveryPartner = new DeliveryPartner(partnerId);
        deliveryPartnerMap.put(partnerId, deliveryPartner);
    }

    public Order getOrder(String orderId) {
        //if(orderId == null) return new Order();

        if(orderMap.containsKey(orderId)) return orderMap.get(orderId);
        //else return new Order();
        return null;
    }


    public DeliveryPartner getPartner(String partnerId) {
        if(partnerId == null) return null;

        return deliveryPartnerMap.get(partnerId);
    }

    public List<String> getAllOrders() {
        List<String> orders = new LinkedList<>();
        for (String order : orderMap.keySet()) {
            orders.add(order);
        }
        return orders;
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        return " ";
    }

    public List<String> getOrdersByPartnerId(String partnerId) {
        List<String> ordersList = new ArrayList<String>();
        if(orderPartnerMap.containsKey(partnerId))
            ordersList = orderPartnerMap.get(partnerId);
        return ordersList;
    }

    public Integer getOrderCountByPartnerId(String partnerId) {
        if(deliveryPartnerMap.containsKey(partnerId))
            return count.getNumberOfOrders();
        else return 0;
    }

    public Integer getCountOfUnassignedOrders() {
        return 1;
    }

    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String partnerId) {
        return 1;
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {

        if(deliveryPartnerMap.containsKey(partnerId) && orderMap.containsKey(orderId)){
            List<String> orders = new ArrayList<>();
            if(orderPartnerMap.containsKey(partnerId)){
                orders = orderPartnerMap.get(partnerId);
            }
            orders.add(orderId);
            count.setNumberOfOrders(count.getNumberOfOrders() + 1);
            orderPartnerMap.put(partnerId, orders);
        }
    }

    public void deletePartnerById(String partnerId) {
        //DeliveryPartner partner = deliveryPartnerMap.get(partnerId);
        List<String> assignedOrders = orderPartnerMap.get(partnerId);
        for(String str : assignedOrders){
            deliveryPartnerMap.remove(str);
        }
        orderPartnerMap.remove(partnerId);
    }

    public void deleteOrderById(String orderId) {
        List<String> assignedOrders = orderPartnerMap.get(orderId);
        for(String str : assignedOrders) {
            orderMap.remove(str);
        }
    }
}
