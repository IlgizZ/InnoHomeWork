package ru.innopolis.bs3_1.zamaleev.ingredients.impl;

import ru.innopolis.bs3_1.zamaleev.ingredients.Veggie;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class Olive implements Veggie {
    public Olive() {
    }

    @Override
    public void giveSpecificTaste() {
        System.out.println("Olive make our pizza more interesting");
    }
}
