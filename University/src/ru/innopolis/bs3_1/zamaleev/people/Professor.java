package ru.innopolis.bs3_1.zamaleev.people;

import ru.innopolis.bs3_1.zamaleev.education.Lecture;
import ru.innopolis.bs3_1.zamaleev.education.Subject;
import ru.innopolis.bs3_1.zamaleev.untils.AssertionsMethods;

/**
 * Created by Ilgiz on 24.08.2016.
 */
public class Professor extends Employer {

    private int id;

    public Professor(Name name, int id) {
        super(name);

        assert (id > 0);

        this.id = id;
    }

    public void teach(Subject subject) {
        assert (AssertionsMethods.isEmptyString(subject.getTitle()));

        System.out.println("Professor: \"Some new things about " + subject.getTitle() + " to " +
                subject.getCourseYear() + " year students.");
    }

    public int getId() {
        return id;
    }

    public Lecture prepareLecture(String name) {
        return null;
    }

}
