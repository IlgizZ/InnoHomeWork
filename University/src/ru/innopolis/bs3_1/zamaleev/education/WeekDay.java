package ru.innopolis.bs3_1.zamaleev.education;

import ru.innopolis.bs3_1.zamaleev.enums.WeekDayName;
import ru.innopolis.bs3_1.zamaleev.untils.AssertionsMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 24.08.2016.
 */
public class WeekDay {
    private WeekDayName name;
    private List<Lesson> lessons;

    public WeekDay(WeekDayName name) {

        this.name = name;

        assert (AssertionsMethods.isNull(this.name));

        lessons = new ArrayList();
    }

    public WeekDayName getName() {
        return name;
    }

    public void setName(WeekDayName name) {
        assert (name != null);

        this.name = name;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        assert (lessons != null && lessons.size() > 0);


        this.lessons = lessons;
    }

    public void addLecture(Lesson lesson) {
        assert (lesson != null);

        lessons.add(lesson);
        lessons.sort((o1, o2) -> {
            return o1.getTime().compareTo(o2.getTime());
        });
    }

    public boolean removeLecture(Lesson lesson) {
        return lessons.remove(lesson);
    }
}
