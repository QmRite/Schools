package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVParser {
    public static ArrayList<String[]> parse(String path, boolean removeHeader){
        ArrayList<String[]> result = new ArrayList<>();
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(path));

            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = Arrays.stream(line.split(","))
                        .map(s -> s.replace("\"", ""))
                        .toArray(String[]::new);
                result.add(columns);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (removeHeader){
            result.remove(0);
        }
        return result;
    }
}
