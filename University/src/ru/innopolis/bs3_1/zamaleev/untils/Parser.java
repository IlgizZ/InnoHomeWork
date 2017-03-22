package ru.innopolis.bs3_1.zamaleev.untils;

import ru.innopolis.bs3_1.zamaleev.education.*;
import ru.innopolis.bs3_1.zamaleev.enums.CourseYear;
import ru.innopolis.bs3_1.zamaleev.enums.LectureTime;
import ru.innopolis.bs3_1.zamaleev.enums.WeekDayName;
import ru.innopolis.bs3_1.zamaleev.people.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 25.10.2016.
 */
public class Parser {
    private List<Professor> professors;
    private List<Student> students;
    private List<TA> tas;
    private List<WeekDay> weekDays;
    private List<Group> groups;

    public Parser() {
        professors = new ArrayList();
        students = new ArrayList();
        tas = new ArrayList();
        groups = new ArrayList();
        weekDays = new ArrayList();
        WeekDayName[] names = WeekDayName.values();
        for (int i = 0; i < names.length; i++) {
            weekDays.add(new WeekDay(names[i]));
        }

        CourseYear[] courseYears = CourseYear.values();
        for (int i = 0; i < courseYears.length; i++) {
            groups.add(new Group(courseYears[i]));
        }
    }

    private String getEntry(String line) {
        String result = null;
        int i = 0;
        while (line.charAt(i) == ' ' || line.charAt(i) == '\t')
            i++;
        line = line.substring(i);
        String[] s = line.split(" ");
        line = s[1];
        int first = line.indexOf("\"");
        int last = line.lastIndexOf("\"");
        result = line.substring(first + 1, last);

        assert (AssertionsMethods.isEmptyString(result));

        return result;
    }

    public void parse(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
            String str = null;

            //parse Professors
            bufferedReader.readLine();
            while (!(str = bufferedReader.readLine()).contains("}")) {
                String s = bufferedReader.readLine();
                String id = getEntry(s);
                String name = getEntry(bufferedReader.readLine());
                String surname = getEntry(bufferedReader.readLine());
                professors.add(new Professor(new Name(name, surname), Integer.valueOf(id)));
                bufferedReader.readLine();
            }
            //parse TAs

            bufferedReader.readLine();
            while (!(str = bufferedReader.readLine()).contains("}")) {
                int id = Integer.valueOf(getEntry(bufferedReader.readLine()));
                int profId = Integer.valueOf(getEntry(bufferedReader.readLine()));
                String surname = getEntry(bufferedReader.readLine());
                String name = getEntry(bufferedReader.readLine());

                Professor professor = null;
                for (Professor professor1 : professors) {
                    if (professor1.getId() == profId) {
                        professor = professor1;
                        break;
                    }
                }

                tas.add(new TA(new Name(name, surname), id, professor));
                bufferedReader.readLine();
            }
            //parse subjects

            bufferedReader.readLine();
            while (!(str = bufferedReader.readLine()).contains("}")) {
                int id = Integer.valueOf(getEntry(bufferedReader.readLine()));
                boolean isLab = (getEntry(bufferedReader.readLine())).equals("true");
                String title = getEntry(bufferedReader.readLine());

                int profID = 0;
                CourseYear course = null;
                int taID = 0;
                Professor professor = null;
                TA ta = null;

                if (isLab) {
                    course =
                            CourseYear.valueOf(
                                    getEntry(bufferedReader.readLine()));
                    taID = Integer.valueOf(getEntry(bufferedReader.readLine()));
                    for (TA ta1 : tas) {
                        if (ta1.getId() == taID) {
                            ta = ta1;
                            break;
                        }
                    }
                } else {
                    profID = Integer.valueOf(getEntry(bufferedReader.readLine()));
                    for (Professor professor1 : professors) {
                        if (professor1.getId() == profID) {
                            professor = professor1;
                            break;
                        }
                    }
                }

                int room = Integer.valueOf(getEntry(bufferedReader.readLine()));
                LectureTime time = LectureTime.values()[Integer.valueOf(getEntry(bufferedReader.readLine())) - 1];
                int weekDay = Integer.valueOf(getEntry(bufferedReader.readLine()));

                Subject subject;

                if (isLab) {
                    subject = new Lab(title, null);
                    subject.setTa(ta);

                } else {
                    subject = new Lecture(title, professor);
                    professor.addSubject(subject);
                }

                subject.setCourseYear(course);

                Lesson lesson = new Lesson();
                lesson.setRoom(room);
                lesson.setTime(time);
                lesson.setSubject(subject);

                WeekDayName name = WeekDayName.values()[weekDay - 1];

                for (WeekDay day : weekDays) {
                    if (day.getName() == name)
                        day.addLecture(lesson);
                }

                bufferedReader.readLine();
            }

            //parse students & group
            bufferedReader.readLine();
            while (!(str = bufferedReader.readLine()).contains("}")) {
                String name = getEntry(bufferedReader.readLine());
                String surname = getEntry(bufferedReader.readLine());

                CourseYear course =
                        CourseYear.valueOf(
                                getEntry(bufferedReader.readLine()));

                Student student = new Student(new Name(name, surname));

                groups.forEach(group -> {
                    if (group.getCourseYear() == course) {
                        student.setGroup(group);
                        group.addStudent(student);
                        return;
                    }
                });

                weekDays.forEach(weekDay -> {
                    weekDay.getLessons().forEach(lesson -> {
                        if (lesson.getSubject().getCourseYear() == course) {
                            student.addLesson(lesson);
                            return;
                        }
                    });
                });

                students.add(student);
                bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Professor> getProfessors() {
        assert (professors != null);
        return professors;
    }

    public List<Student> getStudents() {
        assert (students != null);

        return students;
    }

    public List<TA> getTas() {
        assert (tas != null);
        return tas;
    }

    public List<WeekDay> getWeekDays() {
        assert (weekDays != null);
        return weekDays;
    }

    public List<Group> getGroups() {
        assert (groups != null);
        return groups;
    }
}
