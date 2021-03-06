package com.sda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoivodshipMapper {
    public static Map<Integer, String> map(List<String> list){
        Map<Integer, String> voivodshipMap = new HashMap<>();
        list.stream()
                .filter( record -> !record.isBlank())
                .filter( record -> record.contains("województwo"))
                .forEach( record -> {
                    voivodshipMap.put(Integer.valueOf(record.split(";")[0]), record.split(";")[4]);
                });

        return voivodshipMap;
    }
}
