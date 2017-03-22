package ru.innopolis.bs3_1.zamaleev.tatMak;

import ru.innopolis.bs3_1.zamaleev.*;
import ru.innopolis.bs3_1.zamaleev.pizza.CheesePizza;
import ru.innopolis.bs3_1.zamaleev.pizza.ChickenPizza;
import ru.innopolis.bs3_1.zamaleev.pizza.PepperoniPizza;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class TatMakPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(PizzaType type) {
        Pizza pizza = null;
        IngredientFactory ingredientFactory = new TatMakIngredientFactory();

        switch (type) {
            case CHEESE:
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("Tat mak pizza style Cheese pizza");
                return pizza;
            case CHICKEN:
                pizza = new ChickenPizza(ingredientFactory);
                pizza.setName("Tat mak pizza style Chicken pizza");
                return pizza;
            case PEPPERONI:
                pizza = new PepperoniPizza(ingredientFactory);
                pizza.setName("Tat mak pizza style Pepperoni pizza");
                return pizza;
        }

        return pizza;
    }
}
