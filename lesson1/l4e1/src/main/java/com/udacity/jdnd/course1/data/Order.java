package com.udacity.jdnd.course1.data;

public class Order {
    private Integer id;
    private Integer customerId;

    public Order(Integer id, Integer customer_id) {
        this.id = id;
        this.customerId = customer_id;
    }
}
