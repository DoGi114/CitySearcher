package com.sda;

import com.sda.model.Location;
import com.sda.model.LocationType;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class VacationTargetGenerator {

    public static Location getRandomLocation(List<Location> locations){
        if(!locations.isEmpty()){
            Random randomizer = new Random();
            return locations.get(randomizer.nextInt(locations.size()));
        }else{
            throw new RuntimeException("List is empty!");
        }
    }

    public static Location getRandomLocation(List<Location> locations, LocationType locationType){
        locations = locations.stream()
                .filter( location -> location.getType().equals(locationType))
                .collect(Collectors.toList());
        if(!locations.isEmpty()){
            Random randomizer = new Random();
            return locations.get(randomizer.nextInt(locations.size()));
        }else{
            throw new RuntimeException("List is empty!");
        }
    }
}
