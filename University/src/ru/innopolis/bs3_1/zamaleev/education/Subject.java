package ru.innopolis.bs3_1.zamaleev.education;

import ru.innopolis.bs3_1.zamaleev.enums.CourseYear;
import ru.innopolis.bs3_1.zamaleev.people.Professor;
import ru.innopolis.bs3_1.zamaleev.people.TA;
import ru.innopolis.bs3_1.zamaleev.untils.AssertionsMethods;

/**
 * Created by Ilgiz on 06.09.2016.
 */

public class Subject {
    private String title;
    private CourseYear courseYear;
    private Professor professor;
    private TA ta;

    public Subject(String title, Professor professor) {

        this.title = title;

        assert (AssertionsMethods.isEmptyString(this.title));

        this.professor = professor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        assert (AssertionsMethods.isEmptyString(title));

        this.title = title;
    }

    public CourseYear getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(CourseYear courseYear) {

        this.courseYear = courseYear;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        assert (professor != null);

        this.professor = professor;
    }

    public TA getTa() {
        return ta;
    }

    public void setTa(TA ta) {
        assert (ta != null);

        this.ta = ta;
    }

    public boolean isLecture() {
        return this instanceof Lecture;
    }
}
