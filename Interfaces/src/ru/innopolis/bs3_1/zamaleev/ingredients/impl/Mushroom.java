package ru.innopolis.bs3_1.zamaleev.ingredients.impl;

import ru.innopolis.bs3_1.zamaleev.ingredients.Veggie;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class Mushroom implements Veggie {
    public Mushroom() {
    }

    @Override
    public void giveSpecificTaste() {
        System.out.println("Mushroom make our pizza more nutritious");
    }
}
