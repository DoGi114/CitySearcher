package com.sda;

import com.sda.model.Location;
import com.sda.model.LocationType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class VacationTargetGeneratorTest {
    private List<String> parsedFile;
    private List<Location> locationList;

    @Before
    public void setUp(){
        parsedFile = DataLoader.loadFromFile("data/TERC.CSV");
        locationList = LocationMapper.map(parsedFile);

    }

    @Test
    public void getRandomLocationTest(){
        Assert.assertTrue(VacationTargetGenerator.getRandomLocation(locationList) != null);
    }

    @Test
    public void getRandomLocation2(){
        Assert.assertTrue(VacationTargetGenerator.getRandomLocation(locationList, LocationType.CITY) != null);
    }
}
