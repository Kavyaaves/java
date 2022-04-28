package com.company;

public enum Category {
    STATIONARY(0.08), ELECTRONICS(0.1), SNACKS(0.04), FOOD(0.02);
    private Double tax;
    Category(Double tax) {
        this.tax = tax;
    }
    public Double getTax(){
        return this.tax;
    }
};



