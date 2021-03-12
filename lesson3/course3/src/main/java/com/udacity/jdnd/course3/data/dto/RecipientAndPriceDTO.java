package com.udacity.jdnd.course3.data.dto;

import java.math.BigDecimal;

public class RecipientAndPriceDTO {
    private String recipientName;
    private BigDecimal price;

    public RecipientAndPriceDTO() {
    }

    public RecipientAndPriceDTO(String recipientName, BigDecimal price) {
        this.recipientName = recipientName;
        this.price = price;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
