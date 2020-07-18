package com.sda;

import com.sda.model.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LocationMapper {
    public List<Location> map(List<String> list) {
        VoivodshipMapper voivodshipMapper = new VoivodshipMapper();
        Map<Integer, String> voivodshipMap = voivodshipMapper.map(list);

        List<Location> locationList = list.stream()
                .filter(line -> line.matches(".*;gmina .*;.*"))
                .map(line -> {
                    Location location;
                    String[] separetedRecord = line.split(";");
                    String name = separetedRecord[4];
                    String voivodship = voivodshipMap.get(separetedRecord[0]);
                    LocationType locationType;

                    switch (separetedRecord[5]) {
                        case "gmina wiejska":
                            locationType = LocationType.VILLAGE;
                            location = new Village(name, locationType, voivodship);
                            break;
                        case "gmina wiejsko-miejska":
                            locationType = LocationType.URBAN_RURAL;
                            location = new UrbanRural(name, locationType, voivodship);
                            break;
                        case "gmina miejska":
                            locationType = LocationType.CITY;
                            location = new City(name, locationType, voivodship);
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + separetedRecord[5]);
                    }

                    return location;
                }).collect(Collectors.toList());

        return locationList;
    }
}
