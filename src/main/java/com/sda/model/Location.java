package com.sda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Location {
    private final String name;
    private final LocationType type;
    private final String voivodeship;

    public abstract String sayGreetings();

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", voivodeship='" + voivodeship + '\'' +
                '}';
    }
}
