package com.sda;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    public List<String> loadFromFile(String path){
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            System.err.println("File not found");
            return new ArrayList<>();
        }
    }
}
