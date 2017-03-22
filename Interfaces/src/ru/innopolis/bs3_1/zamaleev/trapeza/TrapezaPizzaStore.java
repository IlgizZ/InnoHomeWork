package ru.innopolis.bs3_1.zamaleev.trapeza;

import ru.innopolis.bs3_1.zamaleev.IngredientFactory;
import ru.innopolis.bs3_1.zamaleev.Pizza;
import ru.innopolis.bs3_1.zamaleev.PizzaStore;
import ru.innopolis.bs3_1.zamaleev.PizzaType;
import ru.innopolis.bs3_1.zamaleev.pizza.CheesePizza;
import ru.innopolis.bs3_1.zamaleev.pizza.ChickenPizza;
import ru.innopolis.bs3_1.zamaleev.pizza.PepperoniPizza;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class TrapezaPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(PizzaType type) {
        Pizza pizza = null;
        IngredientFactory ingredientFactory = new TrapezaIngredientFactory();

        switch (type) {
            case CHEESE:
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("Trapeza pizza style Cheese pizza");
                return pizza;
            case CHICKEN:
                pizza = new ChickenPizza(ingredientFactory);
                pizza.setName("Trapeza pizza style Chicken pizza");
                return pizza;
            case PEPPERONI:
                pizza = new PepperoniPizza(ingredientFactory);
                pizza.setName("Trapeza pizza style Pepperoni pizza");
                return pizza;
        }

        return pizza;
    }

}
