package ru.innopolis.bs3_1.zamaleev.ingredients.impl;

import ru.innopolis.bs3_1.zamaleev.ingredients.Cheese;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class RussianCheese implements Cheese {
    public RussianCheese() {
    }

    @Override
    public void melt() {
        System.out.println("not the worst cheese, make our pizza classical");
    }
}
