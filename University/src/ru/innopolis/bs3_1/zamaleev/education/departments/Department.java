package ru.innopolis.bs3_1.zamaleev.education.departments;

import ru.innopolis.bs3_1.zamaleev.education.Timetable;
import ru.innopolis.bs3_1.zamaleev.education.WeekDay;
import ru.innopolis.bs3_1.zamaleev.enums.UniversityName;
import ru.innopolis.bs3_1.zamaleev.enums.YearHalf;
import ru.innopolis.bs3_1.zamaleev.people.Professor;
import ru.innopolis.bs3_1.zamaleev.people.Student;
import ru.innopolis.bs3_1.zamaleev.people.TA;
import ru.innopolis.bs3_1.zamaleev.untils.Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 25.10.2016.
 */
public abstract class Department {

    private List<Professor> professors;
    private List<Student> students;
    private List<TA> tAs;
    private Timetable timetable;

    public Department() {
        professors = new ArrayList();
        students = new ArrayList();
        tAs = new ArrayList();
        timetable = new Timetable(YearHalf.FALL);
    }

    public void prepareEducationProcess() {
        Parser parser = new Parser();
        parser.parse("university_information.txt");
        findProfessors(parser.getProfessors());
        findTAs(parser.getTas());
        findStudents(parser.getStudents());
        createTimetable(parser.getWeekDays());
    }

    public static Department getInstance(UniversityName university) {
        switch (university) {
            case IU: {
                return new InnopolisDepartment();
            }
            default:
                throw new AssertionError("no such university department found");
        }
    }

    private void createTimetable(List<WeekDay> weekDays) {
        timetable.setWeekDays(weekDays);
        System.out.println("Timetable creating complete.");

    }

    private void findStudents(List<Student> parseStudents) {

        this.students = parseStudents;

        System.out.println("We found students.");

    }

    private void findTAs(List<TA> tAs) {

        this.tAs = tAs;
        System.out.println("We found the best TAS.");

    }

    private void findProfessors(List<Professor> professors) {

        this.professors = professors;

        System.out.println("We found the best professors.");
    }

    public void startLessons() {
        System.out.println("\nStart education.");

        for (int i = 0; i < YearHalf.FALL.getWeekCount(); i++) {
            System.out.println("Week number: " + (i + 1));
            timetable.getWeekDays().forEach(weekDay -> {
                weekDay.getLessons().forEach(lesson -> {
                    lesson.start(students);
                });
            });
            System.out.println();
        }

    }

    public TA findTABySurname(String name) {
        for (TA tA : tAs) {
            if (tA.getName().getSurname().equals(name))
                return tA;
        }
        return null;
    }

    public Professor findProfessorBySurname(String name) {
        for (Professor professor : professors) {
            if (professor.getName().getSurname().equals(name))
                return professor;
        }
        return null;
    }
}
