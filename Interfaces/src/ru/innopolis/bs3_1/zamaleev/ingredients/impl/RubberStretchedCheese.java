package ru.innopolis.bs3_1.zamaleev.ingredients.impl;

import ru.innopolis.bs3_1.zamaleev.ingredients.Cheese;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class RubberStretchedCheese implements Cheese {

    public RubberStretchedCheese() {
    }

    @Override
    public void melt() {
        System.out.println("stretched cheese the best ingredient for poor student");
    }
}
