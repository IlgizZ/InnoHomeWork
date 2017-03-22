package ru.innopolis.bs3_1.zamaleev.ingredients.impl;

import ru.innopolis.bs3_1.zamaleev.ingredients.Dough;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class ThickCrustDough implements Dough {
    public ThickCrustDough() {
    }

    @Override
    public void getCrunch() {
        System.out.println("mommy like dough very tender and tasty");
    }
}
