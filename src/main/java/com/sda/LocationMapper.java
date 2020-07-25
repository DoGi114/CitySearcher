package com.sda;

import com.sda.model.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class LocationMapper {

    public static List<Location> map(List<String> list) {
        Map<Integer, String> voivodshipMap = VoivodshipMapper.map(list);

        return list.stream()
                .filter(line -> line.matches(".*;gmina .*;.*"))
                .map(getLocationFromStringFunction(voivodshipMap))
                .collect(Collectors.toList());
    }

    private static Function<String, Location> getLocationFromStringFunction(Map<Integer, String> voivodshipMap) {
        return line -> {
            Location location;
            String[] separatedRecord = line.split(";");
            String name = separatedRecord[4];
            String voivodship = voivodshipMap.get(Integer.valueOf(separatedRecord[0]));

            switch (separatedRecord[5].split(",")[0]) {
                case "gmina wiejska":
                    location = new Village(name, voivodship);
                    break;
                case "gmina miejsko-wiejska":
                    location = new UrbanRural(name, voivodship);
                    break;
                case "gmina miejska":
                    location = new City(name, voivodship);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + separatedRecord[5]);
            }

            return location;
        };
    }

}
