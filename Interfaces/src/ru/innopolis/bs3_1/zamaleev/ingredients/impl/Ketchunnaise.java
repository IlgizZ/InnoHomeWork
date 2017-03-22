package ru.innopolis.bs3_1.zamaleev.ingredients.impl;

import ru.innopolis.bs3_1.zamaleev.ingredients.Sauce;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class Ketchunnaise implements Sauce {
    public Ketchunnaise() {
    }

    @Override
    public void giveSpecificTaste() {
        System.out.println("Ketchunnaise is perfect souse for pure student");
    }
}
