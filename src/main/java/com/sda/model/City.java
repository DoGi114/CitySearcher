package com.sda.model;

public class City extends Location {

    public City(String name, String voivodeship) {
        super(name, LocationType.CITY, voivodeship);
    }

    @Override
    public String sayGreetings() {
        return String.format("Welcome to our quite developed %s of opportunities, %s", getType().toString().toLowerCase(), getName());
    }
}
