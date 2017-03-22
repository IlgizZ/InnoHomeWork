package ru.innopolis.bs3_1.zamaleev;

import ru.innopolis.bs3_1.zamaleev.ingredients.*;

import java.util.List;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected List<Veggie> veggies;
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Chicken chicken;
    protected IngredientFactory ingredientFactory;

    public Pizza(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    protected abstract void prepare();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    protected void cut() {
        System.out.println("Cutting the pizza");
    }

    protected void box() {
        System.out.println("Place pizza in the best pizza box.");
    }


}
