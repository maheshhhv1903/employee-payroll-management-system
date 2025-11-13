package com.payroll;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String FILE_PATH = "employees.json";
    private static Gson gson = new Gson();

    public static void save(List<Employee> employees) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(employees, writer);
        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }

    public static List<Employee> load() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, new TypeToken<List<Employee>>() {
            }.getType());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}