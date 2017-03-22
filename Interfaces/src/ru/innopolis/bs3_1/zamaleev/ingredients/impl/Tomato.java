package ru.innopolis.bs3_1.zamaleev.ingredients.impl;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class Tomato implements ru.innopolis.bs3_1.zamaleev.ingredients.Veggie {
    public Tomato() {
        giveSpecificTaste();
    }

    @Override
    public void giveSpecificTaste() {
        System.out.println("Tomato, how without it?:)");
    }
}
