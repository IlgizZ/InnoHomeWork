package ru.innopolis.bs3_1.zamaleev.ingredients.impl;

import ru.innopolis.bs3_1.zamaleev.ingredients.Veggie;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class Salad implements Veggie {
    public Salad() {
    }

    @Override
    public void giveSpecificTaste() {
        System.out.println("Cucumber make our pizza less dry");

    }
}
