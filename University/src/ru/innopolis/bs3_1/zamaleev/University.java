package ru.innopolis.bs3_1.zamaleev;

import ru.innopolis.bs3_1.zamaleev.education.departments.Department;
import ru.innopolis.bs3_1.zamaleev.enums.UniversityName;

/**
 * Created by Ilgiz on 24.08.2016.
 */
public class University {

    private String name;
    private Department department;

    public University(String name) {
        this.name = name;

    }

    public void startEducation() {
        buildUniversity();
        department = Department.getInstance(UniversityName.valueOf(name));
        department.prepareEducationProcess();
        department.startLessons();
    }


    private void buildUniversity() {
        System.out.println(name + " building done.");
    }
}
