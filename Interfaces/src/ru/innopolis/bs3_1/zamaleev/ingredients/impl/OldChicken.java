package ru.innopolis.bs3_1.zamaleev.ingredients.impl;

import ru.innopolis.bs3_1.zamaleev.ingredients.Chicken;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class OldChicken implements Chicken {
    public OldChicken() {
    }

    @Override
    public void giveNutritious() {
        System.out.println("That chicken give some nutritious");
    }
}
