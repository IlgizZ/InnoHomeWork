package ru.innopolis.bs3_1.zamaleev.ingredients.impl;

import ru.innopolis.bs3_1.zamaleev.ingredients.Dough;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class ThinCrustDough implements Dough {
    public ThinCrustDough() {
    }

    @Override
    public void getCrunch() {
        System.out.println("Thin dough give to our pizza specific crunch");
    }
}
