package ru.innopolis.bs3_1.zamaleev.ingredients.impl;

import ru.innopolis.bs3_1.zamaleev.ingredients.Sauce;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class MarinaraSauce implements Sauce {
    public MarinaraSauce() {
    }

    @Override
    public void giveSpecificTaste() {
        System.out.println("Marinara is perfect Italian sauce, let's make our pizza delicious");

    }
}
