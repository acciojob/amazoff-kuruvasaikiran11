package com.driver;

public class Order {

    private String id;
    private int deliveryTime;

    public Order(String id, String deliveryTime) {

        this.id = id;
        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
        //noinspection UnusedAssignment
        deliveryTime = String.valueOf((Integer.parseInt(String.valueOf(deliveryTime.charAt(0)))*10 +
                Integer.parseInt(String.valueOf(deliveryTime.charAt(1))))*60 +
                (Integer.parseInt(String.valueOf(deliveryTime.charAt(3)))*10 +
                        Integer.parseInt(String.valueOf(deliveryTime.charAt(4)))));
        this.deliveryTime = Integer.parseInt(deliveryTime);
    }

    public String getId() {
        return id;
    }

    public int getDeliveryTime() {return deliveryTime;}
}
