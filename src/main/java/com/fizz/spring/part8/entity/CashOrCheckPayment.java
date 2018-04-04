package com.fizz.spring.part8.entity;

public class CashOrCheckPayment extends Payment {

    public CashOrCheckPayment() {
    }

    @Override
    public String toString() {
        return "CASH or CHECK:  $" + getAmount();
    }

}
