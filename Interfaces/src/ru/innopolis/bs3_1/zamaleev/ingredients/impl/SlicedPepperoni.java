package ru.innopolis.bs3_1.zamaleev.ingredients.impl;

import ru.innopolis.bs3_1.zamaleev.ingredients.Pepperoni;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class SlicedPepperoni implements Pepperoni {
    public SlicedPepperoni() {
    }

    @Override
    public void makeAcute() {
        System.out.println("the perfect pepperoni is the best way to make good pizza");
    }
}
