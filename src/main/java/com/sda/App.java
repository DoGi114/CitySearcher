package com.sda;

import com.sda.model.Location;

import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GreetingsFileGenerator greetingsFileGenerator = new GreetingsFileGenerator("data/TERC.CSV");
        greetingsFileGenerator.generateFile();
        List<String> dataList = DataLoader.loadFromFile("data/TERC.CSV");
        List<Location> locationList = LocationMapper.map(dataList);
        Location location = VacationTargetGenerator.getRandomLocation(locationList);
        LocationAnalyzer.getLongestNamesLocations(locationList).forEach(System.out::println);
        LocationAnalyzer.getLongestNamedLocationInVoivodship(locationList).forEach((s, location1) -> System.out.println(s + " " + location1));

    }
}
