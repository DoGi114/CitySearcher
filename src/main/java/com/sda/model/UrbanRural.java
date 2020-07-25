package com.sda.model;

public class UrbanRural extends Location {

    public UrbanRural(String name, String voivodeship) {
        super(name, LocationType.URBAN_RURAL, voivodeship);
    }

    @Override
    public String sayGreetings() {
        return String.format("Welcome in %s which will be a great city at some point, %s", getType().toString().toLowerCase(), getName());
    }
}
