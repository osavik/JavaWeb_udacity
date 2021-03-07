package com.udacity.jdnd.course3.data;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

//@Table( name = "plant")
@Entity
public class Flower extends Plant{

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
