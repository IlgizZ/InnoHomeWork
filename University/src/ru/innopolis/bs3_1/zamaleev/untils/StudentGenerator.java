package ru.innopolis.bs3_1.zamaleev.untils;

import ru.innopolis.bs3_1.zamaleev.enums.CourseYear;
import ru.innopolis.bs3_1.zamaleev.people.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 25.10.2016.
 */
public class StudentGenerator {
    public static void generateTo(String fileName) {
        List<String> names = new ArrayList();
        List<String> surNames = new ArrayList();
        names.add("Vasya");
        names.add("Pite");
        names.add("Stas");
        names.add("Mansur");
        names.add("Mickle");
        names.add("Sergey");
        names.add("Roman");
        surNames.add("Ivanov");
        surNames.add("Petrov");
        surNames.add("Sidorov");
        surNames.add("Gavrikov");
        surNames.add("Iliin");
        surNames.add("Tolstoi");
        surNames.add("Peturin");
        surNames.add("Lomonosov");
        CourseYear[] courseYears = CourseYear.values();
        List<Student> students = new ArrayList();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName)))) {
            writer.write("\"students\": {\n");
            for (int i = 0; i < 100; i++) {
                writer.write("    \"student\": {\n");
                int random = (int) (Math.random() * names.size());
                String name = names.get(random);
                writer.write("        \"name\": \"" + name + "\",\n");

                random = (int) (Math.random() * surNames.size());
                String surName = surNames.get(random);
                writer.write("        \"surname\": \"" + surName + "\",\n");

                random = (int) (Math.random() * courseYears.length);
                CourseYear courseYear = courseYears[random];
                writer.write("        \"course\": \"" + courseYear + "\",\n");
                writer.write("    },\n");
            }
            writer.write("}\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
