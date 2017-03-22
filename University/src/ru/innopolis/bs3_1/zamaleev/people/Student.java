package ru.innopolis.bs3_1.zamaleev.people;

import ru.innopolis.bs3_1.zamaleev.education.Lesson;
import ru.innopolis.bs3_1.zamaleev.education.Subject;
import ru.innopolis.bs3_1.zamaleev.untils.AssertionsMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 24.08.2016.
 */
public class Student {
    public static int currentFreeId = 0;
    private int id;
    private Name name;
    private List<Lesson> lessons;
    private Group group;

    public Student(Name name) {
        this.name = name;
        id = currentFreeId;

        assert (AssertionsMethods.isNull(this.name));

        currentFreeId++;
        lessons = new ArrayList();
    }

    public Name getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(Name name) {
        assert (AssertionsMethods.isNull(name));

        this.name = name;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        assert (AssertionsMethods.isNull(lessons));

        this.lessons = lessons;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        assert (AssertionsMethods.isNull(group));

        this.group = group;
    }

    public void sleep() {
        System.out.println("Zzz...");
    }

    public void study() {
        System.out.println("I read a book.");
    }

    public void study(Subject subject) {
        System.out.println(name + " came on " + subject.getTitle());
    }

    public void eat() {
        System.out.println("Go to \"Trapeza\"!");
    }

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }
}
