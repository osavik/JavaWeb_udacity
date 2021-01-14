package com.udacity.jdnd.course1.data;

public class TacoOrder {

    private Integer orderId;
    private String tacoName;
    private Double tacoPrice;
    private Integer count;

    public TacoOrder(Integer order_id, String taco_name, Double taco_price, Integer count) {
        this.orderId = order_id;
        this.tacoName = taco_name;
        this.tacoPrice = taco_price;
        this.count = count;
    }
}
