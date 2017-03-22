package ru.innopolis.bs3_1.zamaleev.people;

import ru.innopolis.bs3_1.zamaleev.untils.AssertionsMethods;

/**
 * Created by Ilgiz on 26.08.2016.
 */
public class Name {
    private String name;
    private String surName;

    public Name(String name, String surName) {
        assert (AssertionsMethods.isEmptyString(name));
        assert (AssertionsMethods.isEmptyString(surName));
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        assert (AssertionsMethods.isEmptyString(name));

        this.name = name;
    }

    public String getSurname() {
        return surName;
    }

    public void setSurName(String surName) {
        assert (AssertionsMethods.isEmptyString(surName));

        this.surName = surName;
    }

    @Override
    public String toString() {
        return surName + " " + name;
    }
}
