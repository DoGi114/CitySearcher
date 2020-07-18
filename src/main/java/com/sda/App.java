package com.sda;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        VoivodshipMapper voivodshipMapper = new VoivodshipMapper();
        Map<Integer, String> map = voivodshipMapper.map(new DataLoader().loadFromFile("data/TERC.CSV"));
         map.forEach((idx, value) -> System.out.println(idx + " " + value));

    }
}
