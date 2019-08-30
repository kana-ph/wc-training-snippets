package com.whitecloak.training.models;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Jeremy Salve
 */

public class ItemModel {

    String name;
    LocalDate date;
    int unitsSold;
    BigDecimal price;

    public ItemModel(String name, LocalDate date, Integer unitsSold, BigDecimal price) {
        this.name = name;
        this.date = date;
        this.unitsSold = unitsSold;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getUnitsSold() {
        return unitsSold;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
