package com.sda.model;

public class Village extends Location {

    public Village(String name, String voivodeship) {
        super(name, LocationType.VILLAGE, voivodeship);
    }

    @Override
    public String sayGreetings() {
        return String.format("Welcome in our beautiful %s, %s", getType().toString().toLowerCase(), getName());
    }
}
