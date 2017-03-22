package ru.innopolis.bs3_1.zamaleev.people;

import ru.innopolis.bs3_1.zamaleev.education.Subject;
import ru.innopolis.bs3_1.zamaleev.untils.AssertionsMethods;

/**
 * Created by Ilgiz on 24.08.2016.
 */
public class TA extends Employer {
    private Professor professor;
    private int id;


    public TA(Name name, int id, Professor professor) {
        super(name);

        assert (id > 0);

        this.id = id;
        this.professor = professor;
    }

    public void teach(Subject subject) {
        assert (AssertionsMethods.isEmptyString(subject.getTitle()));
        assert (subject.getCourseYear() != null);

        System.out.println("TA: \"Repeat previous lecture by " + subject.getTitle() + ".\"\n" + "To " +
                subject.getCourseYear() + " group.");
    }

    public int getId() {
        return id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
