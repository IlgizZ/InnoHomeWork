package ru.innopolis.bs3_1.zamaleev.education;

import ru.innopolis.bs3_1.zamaleev.enums.WeekDayName;
import ru.innopolis.bs3_1.zamaleev.enums.YearHalf;
import ru.innopolis.bs3_1.zamaleev.untils.AssertionsMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 24.08.2016.
 */
public class Timetable {
    private YearHalf yearHalf;
    private List<WeekDay> weekDays;

    public Timetable(YearHalf yearHalf) {
        this.yearHalf = yearHalf;

        assert (AssertionsMethods.isNull(this.yearHalf));

        this.weekDays = new ArrayList();
        initialize();
    }


    public YearHalf getYearHalf() {
        return yearHalf;
    }

    public void setYearHalf(YearHalf yearHalf) {
        assert (yearHalf != null);

        this.yearHalf = yearHalf;
    }

    public List<WeekDay> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(List<WeekDay> weekDays) {
        assert (weekDays != null && weekDays.size() > 0);

        this.weekDays = weekDays;
    }

    public WeekDay getWeekDayByName(WeekDayName name) {
        for (WeekDay weekDay : weekDays) {
            if (weekDay.getName().equals(name))
                return weekDay;
        }
        return null;
    }

    private void initialize() {
        weekDays.add(new WeekDay(WeekDayName.MONDAY));
        weekDays.add(new WeekDay(WeekDayName.TUESDAY));
        weekDays.add(new WeekDay(WeekDayName.WEDNESDAY));
        weekDays.add(new WeekDay(WeekDayName.THURSDAY));
        weekDays.add(new WeekDay(WeekDayName.FRIDAY));
        weekDays.add(new WeekDay(WeekDayName.SATURDAY));
        weekDays.add(new WeekDay(WeekDayName.SUNDAY));

        assert (weekDays.size() == 7);
    }
}
