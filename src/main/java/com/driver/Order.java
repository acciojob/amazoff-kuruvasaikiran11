package com.driver;

import io.swagger.models.auth.In;

public class Order {

    private String id;
    private int deliveryTime;
    public Order(){}
    public Order(String id, String dTime) {

        this.id = id;
        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
        //noinspection UnusedAssignment
        String dT[] = dTime.split(":");
        int hrs = Integer.parseInt(dT[0]);
        int mins = Integer.parseInt(dT[1]);
        this.deliveryTime = hrs * 60 + mins;
    }

    public String getId() {
        return id;
    }

    public int getDeliveryTime() {return deliveryTime;}
}
