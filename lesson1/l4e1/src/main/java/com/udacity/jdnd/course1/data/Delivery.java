package com.udacity.jdnd.course1.data;

import java.sql.Timestamp;

public class Delivery {

    private Integer id;
    private Integer orderId;
    private Timestamp time;

    public Delivery(Integer id, Integer order_id, Timestamp time) {
        this.id = id;
        this.orderId = order_id;
        this.time = time;
    }
}
