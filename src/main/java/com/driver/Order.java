package com.driver;

import io.swagger.models.auth.In;

public class Order {

    private String id;
    private String deliveryTime;
    public Order(){}
    public Order(String id, String deliveryTime) {

        this.id = id;
        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
        //noinspection UnusedAssignment
        String dT[] = deliveryTime.split(":");
        int hrs = Integer.parseInt(dT[0]);
        int mins = Integer.parseInt(dT[1]);
        this.deliveryTime = String.valueOf(hrs * 60 + mins);
    }

    public String getId() {
        return id;
    }

    public int getDeliveryTime() {return Integer.parseInt(deliveryTime);}
}
