package ru.innopolis.bs3_1.zamaleev.people;

import ru.innopolis.bs3_1.zamaleev.education.Subject;
import ru.innopolis.bs3_1.zamaleev.untils.AssertionsMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 06.09.2016.
 */
public class Employer {
    private Name name;
    private List<Subject> subjects;

    public Employer(Name name) {
        assert (AssertionsMethods.isNull(name));

        this.name = name;
        subjects = new ArrayList();
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        assert (name != null);

        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        assert (AssertionsMethods.isNull(subjects) && subjects.size() > 0);

        this.subjects = subjects;
    }

    public boolean addSubject(Subject subject) {
        assert (AssertionsMethods.isNull(subject));

        return subjects.add(subject);
    }

}
