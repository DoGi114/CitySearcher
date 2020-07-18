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
        GreetingsFileGenerator greetingsFileGenerator = new GreetingsFileGenerator("data/TERC.CSV");
        greetingsFileGenerator.generateFile();

    }
}
