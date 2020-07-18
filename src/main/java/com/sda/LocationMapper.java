package com.sda;

import com.sda.model.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LocationMapper {
    public static List<Location> map(List<String> list) {
        Map<Integer, String> voivodshipMap = VoivodshipMapper.map(list);

        return list.stream()
                .filter(line -> line.matches(".*;gmina .*;.*"))
                .map(line -> {
                    Location location;
                    String[] separetedRecord = line.split(";");
                    String name = separetedRecord[4];
                    String voivodship = voivodshipMap.get(Integer.valueOf(separetedRecord[0]));

                    switch (separetedRecord[5].split(",")[0]) {
                        case "gmina wiejska":
                            location = new Village(name, LocationType.VILLAGE, voivodship);
                            break;
                        case "gmina miejsko-wiejska":
                            location = new UrbanRural(name, LocationType.URBAN_RURAL, voivodship);
                            break;
                        case "gmina miejska":
                            location = new City(name, LocationType.CITY, voivodship);
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + separetedRecord[5]);
                    }

                    return location;
                }).collect(Collectors.toList());
    }
}
