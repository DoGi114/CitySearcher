package com.sda;

import com.sda.model.Location;
import com.sda.model.Village;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/** 
* LocationAnalyzer Tester. 
* 
* @author <Authors name> 
* @since <pre>lip 25, 2020</pre> 
* @version 1.0 
*/ 
public class LocationAnalyzerTest { 

    private List<Location> testLocations;

@Before
public void before() throws Exception {
    testLocations = new ArrayList<>();
    testLocations.add(new Village("Pcim Dolny", "KOSZALIŃSKIE"));
    testLocations.add(new Village("Mipc Dolny", "KOSZALIŃSKIE"));
    testLocations.add(new Village("Pcim", "KOSZALIŃSKIE"));
    testLocations.add(new Village("Pcim Dolny", "KOSZALIŃSKIE"));
    testLocations.add(new Village("Pruszków", "WARSZAWSKIE"));
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getLongestNamesLocations(List<Location> locationList) 
* 
*/ 
@Test
public void testGetLongestNamesLocations() throws Exception { 
    List<Location> longestNamedLocationsLocationList = LocationAnalyzer.getLongestNamesLocations(testLocations);
    assertEquals(2, longestNamedLocationsLocationList.size());
    List<Location> filtered = longestNamedLocationsLocationList.stream()
            .filter(location -> location.getVoivodeship().equals("KOSZALIŃSKIE")).collect(Collectors.toList());
    assertEquals(2, filtered.size());
}

/** 
* 
* Method: getLongestNamedLocationInVoivodship(List<Location> locationList) 
* 
*/ 
@Test
public void testGetLongestNamedLocationInVoivodship() throws Exception { 
    Map<String, List<Location>> longestNamedLocationsInVoivodshipMap =
            LocationAnalyzer.getLongestNamedLocationInVoivodship(testLocations);

    assertEquals(testLocations.get(4), longestNamedLocationsInVoivodshipMap.get("WARSZAWSKIE").get(0));

}


} 
