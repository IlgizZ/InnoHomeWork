package ru.innopolis.bs3_1.zamaleev;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public abstract class PizzaStore {

    public Pizza orderPizza(PizzaType type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        System.out.println("Bon Appetit! Or not:)");
        System.out.println();
        return pizza;
    }

    protected abstract Pizza createPizza(PizzaType type);
}
