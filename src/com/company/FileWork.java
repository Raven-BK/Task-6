package com.company;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FileWork {
    public static File data = new File("data.csv");

    public static Map<String, Map<String, Integer>> dataForMyMap() throws IOException {
        Map<String, Map<String, Integer>> dataOfFile = new SimpleHashMap<>(127);
        Scanner readFile = new Scanner(data);
        while (readFile.hasNextLine()) {
            String[] strings = readFile.nextLine().split(",");
            for (int j = 0; j < 2; j++) {
                StringBuilder builder = new StringBuilder();
                for (int i = 1; i < strings[j].toCharArray().length - 1; i++) {
                    builder.append(strings[j].toCharArray()[i]);
                }
                strings[j] = builder.toString();
            }
            if (dataOfFile.get(strings[1]) == null) {
                Map<String, Integer> dataOfStudent = new SimpleHashMap<>(7);
                dataOfStudent.put(strings[0], Integer.parseInt(strings[2]));
                dataOfFile.put(strings[1], dataOfStudent);
            } else {
                dataOfFile.get(strings[1]).put(strings[0], Integer.parseInt(strings[2]));
            }
        }
        readFile.close();
        return dataOfFile;
    }

    public static Map<String, Map<String, Integer>> dataForJavaMap() throws IOException {
        Map<String, Map<String, Integer>> dataOfFile = new HashMap<>(127);
        Scanner readFile = new Scanner(data);
        while (readFile.hasNextLine()) {
            String[] strings = readFile.nextLine().split(",");
            for (int j = 0; j < 2; j++) {
                StringBuilder builder = new StringBuilder();
                for (int i = 1; i < strings[j].toCharArray().length - 1; i++) {
                    builder.append(strings[j].toCharArray()[i]);
                }
                strings[j] = builder.toString();
            }
            if (dataOfFile.get(strings[1]) == null) {
                Map<String, Integer> dataOfStudent = new HashMap<>(7);
                dataOfStudent.put(strings[0], Integer.parseInt(strings[2]));
                dataOfFile.put(strings[1], dataOfStudent);
            } else {
                dataOfFile.get(strings[1]).put(strings[0], Integer.parseInt(strings[2]));
            }
        }
        readFile.close();
        return dataOfFile;
    }
}
