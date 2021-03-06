package com.sda;

import com.sda.model.Location;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Data
@AllArgsConstructor
public class GreetingsFileGenerator implements FileGenerator {

    private String dataFilePath;

    @Override
    public void generateFile() {
        if(!dataFilePath.isEmpty()) {
            List<String> dataList = DataLoader.loadFromFile(dataFilePath);
            List<Location> locationList = LocationMapper.map(dataList);
            Location location = VacationTargetGenerator.getRandomLocation(locationList);
            
            StringBuilder resultStringBuilder = new StringBuilder();
            resultStringBuilder.append("Name: ")
                    .append(location.getName());
            resultStringBuilder.append(System.lineSeparator());
            resultStringBuilder.append("Voivodship: ")
                    .append(location.getVoivodeship());
            resultStringBuilder.append(System.lineSeparator());
            resultStringBuilder.append("Type: ")
                    .append(location.getType());
            resultStringBuilder.append(System.lineSeparator());
            resultStringBuilder.append(location.sayGreetings());

            try {
                Files.writeString(Paths.get("data/" + location.getName() + "_greetings.txt"), resultStringBuilder);
            } catch (IOException e) {
                System.err.println("IOException :(");
            }
        }else{
            throw new RuntimeException("No file path!");
        }
    }
}
