package com.fizz.spring.part8.entity;

import java.util.Arrays;
import java.util.List;

public enum Topping {

    PEPPERONI,
    SAUSAGE,
    HAMBURGER,
    MUSHROOM,
    CANADIAN_BACON,
    PINEAPPLE,
    GREEN_PEPPER,
    JALAPENO,
    TOMATO,
    ONION,
    EXTRA_CHEESE;

    public static List<Topping> asList() {
        Topping[] all = Topping.values();
        return Arrays.asList(all);
    }

    /*@Override
    public String toString() {
        return WordUtils.capitalizeFully(name().replace('_', ' '));
    }*/

}
