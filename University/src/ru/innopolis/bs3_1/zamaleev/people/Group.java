package ru.innopolis.bs3_1.zamaleev.people;

import ru.innopolis.bs3_1.zamaleev.enums.CourseYear;
import ru.innopolis.bs3_1.zamaleev.untils.AssertionsMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 24.08.2016.
 */
public class Group {
    private CourseYear courseYear;
    private List<Student> students;

    public Group(CourseYear courseYear) {
        assert (courseYear != null);

        this.courseYear = courseYear;
        this.students = new ArrayList();
    }

    public Group(CourseYear courseYear, List<Student> students) {
        assert (courseYear != null && students.size() > 0);

        this.courseYear = courseYear;
        this.students = students;
    }


    public CourseYear getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(CourseYear courseYear) {
        assert (courseYear != null);

        this.courseYear = courseYear;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        assert (AssertionsMethods.isNull(students));


        this.students = students;
    }

    public boolean addStudent(Student student) {
        assert (AssertionsMethods.isNull(student));

        students.forEach(student1 -> {
            if (student1.getId() == student.getId())
                throw new AssertionError("same student id in group " + courseYear);
        });

        return students.add(student);
    }

    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    @Override
    public String toString() {
        return courseYear.toString();
    }
}
