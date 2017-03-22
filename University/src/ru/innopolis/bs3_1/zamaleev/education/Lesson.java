package ru.innopolis.bs3_1.zamaleev.education;

import ru.innopolis.bs3_1.zamaleev.enums.LectureTime;
import ru.innopolis.bs3_1.zamaleev.people.Professor;
import ru.innopolis.bs3_1.zamaleev.people.Student;
import ru.innopolis.bs3_1.zamaleev.people.TA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 30.08.2016.
 */
public class Lesson {
    private Subject subject;
    private int room;
    private LectureTime time;

    public Lesson() {

    }

    public Subject getSubject() {
        return subject;
    }

    public int getRoom() {
        return room;
    }

    public LectureTime getTime() {
        return time;
    }

    public void setSubject(Subject subject) {
        assert (subject != null);
        this.subject = subject;
    }

    public void setRoom(int room) {
        assert (room > 0);
        this.room = room;
    }

    public void setTime(LectureTime time) {
        assert (time != null);

        this.time = time;
    }

    public void start(List<Student> students) {
        int studentCount = students.size();

        List<Student> lectureStudents = new ArrayList();


        if (subject.isLecture()) {
            lectureStudents = students;
            Professor professor = subject.getProfessor();
            System.out.println(time + " class " + subject.getTitle() + " in " + room + " room.");
            System.out.println("Professor " + professor.getName() + " come. Lest's start.");
            professor.teach(subject);

            lectureStudents.forEach(student -> {
                student.study(subject);
            });

            System.out.println();
        } else {

            for (Student student : students) {
                if (student.getGroup().getCourseYear().equals(subject.getCourseYear()))
                    lectureStudents.add(student);
            }

            TA ta = subject.getTa();
            System.out.println(time + " class " + subject.getTitle() + " in " + room + " room.");
            System.out.println("TA " + ta.getName() + " come. Lest's start lab.");
            ta.teach(subject);

            lectureStudents.forEach(student -> {
                student.study(subject);
            });
            System.out.println();
        }

        assert (students.size() == studentCount);
    }

}

