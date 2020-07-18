package com.sda;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class VoivodshipMapperTest {

    private List<String> parsedFile;

    @Before
    public void setUp(){
        parsedFile = new DataLoader().loadFromFile("data/TERC.CSV");
    }

    @Test
    public void mapIsEmptyTest(){
        Assert.assertTrue(!new VoivodshipMapper().map(parsedFile).isEmpty());
    }

    @Test
    public void mapTest() {

        Map<Integer, String> expectedMap = new HashMap<>();
        expectedMap.put(32, "ZACHODNIOPOMORSKIE");
        expectedMap.put(2, "DOLNOŚLĄSKIE");
        expectedMap.put(4, "KUJAWSKO-POMORSKIE");
        expectedMap.put(6, "LUBELSKIE");
        expectedMap.put(8, "LUBUSKIE");
        expectedMap.put(10, "ŁÓDZKIE");
        expectedMap.put(12, "MAŁOPOLSKIE");
        expectedMap.put(14, "MAZOWIECKIE");
        expectedMap.put(16, "OPOLSKIE");
        expectedMap.put(18, "PODKARPACKIE");
        expectedMap.put(20, "PODLASKIE");
        expectedMap.put(22, "POMORSKIE");
        expectedMap.put(24, "ŚLĄSKIE");
        expectedMap.put(26, "ŚWIĘTOKRZYSKIE");
        expectedMap.put(28, "WARMIŃSKO-MAZURSKIE");
        expectedMap.put(30, "WIELKOPOLSKIE");

        Assert.assertTrue(expectedMap.equals(new VoivodshipMapper().map(parsedFile)));

    }
}
