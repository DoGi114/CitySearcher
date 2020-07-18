package com.sda;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LocationMapperTest {
    private List<String> parsedFile;

    @Before
    public void setUp(){
        parsedFile = DataLoader.loadFromFile("data/TERC.CSV");
    }

    @Test
    public void mapIsEmptyTest(){
        Assert.assertTrue(!LocationMapper.map(parsedFile).isEmpty());
    }
}
