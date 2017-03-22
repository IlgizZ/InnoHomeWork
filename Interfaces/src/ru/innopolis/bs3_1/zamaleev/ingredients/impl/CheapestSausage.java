package ru.innopolis.bs3_1.zamaleev.ingredients.impl;

import ru.innopolis.bs3_1.zamaleev.ingredients.Pepperoni;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class CheapestSausage implements Pepperoni {
    public CheapestSausage() {
    }

    @Override
    public void makeAcute() {
        System.out.println("take not the best sausage with small acute");
    }
}
