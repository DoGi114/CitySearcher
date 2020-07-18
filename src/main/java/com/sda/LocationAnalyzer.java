package com.sda;

import com.sda.model.Location;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LocationAnalyzer {
    public static List<Location> getLongestNamesLocations(List<Location> locationList) {
        return locationList.stream()
                .collect(Collectors.groupingBy(location -> location.getName().length()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElseThrow();
    }

    public static Map<String, Location> getLongestNamedLocationInVoivodship(List<Location> locationList){
        Map<String, Location> longestNamedLocationsInVoivodshipList = new HashMap<>();
        locationList.stream()
                .collect(Collectors.groupingBy(Location::getVoivodeship))
                .forEach((key, value1) -> longestNamedLocationsInVoivodshipList.put(key, value1.stream().max(Comparator.comparingInt(value -> value.getName().length())).orElseThrow()));
        return longestNamedLocationsInVoivodshipList;
    }
}
