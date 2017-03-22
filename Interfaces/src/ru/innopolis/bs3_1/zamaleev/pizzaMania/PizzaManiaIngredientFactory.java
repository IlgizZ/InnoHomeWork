package ru.innopolis.bs3_1.zamaleev.pizzaMania;

import ru.innopolis.bs3_1.zamaleev.*;
import ru.innopolis.bs3_1.zamaleev.ingredients.*;
import ru.innopolis.bs3_1.zamaleev.ingredients.impl.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class PizzaManiaIngredientFactory implements IngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new Ketchunnaise();
    }

    @Override
    public Cheese createCheese() {
        return new StretchedCheese();
    }

    @Override
    public List<Veggie> createVeggies() {
        List<Veggie> veggies = new ArrayList();
        veggies.add(new Onion());
        veggies.add(new Salad());
        veggies.add(new Tomato());
        veggies.add(new Cucumber());
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new CheapestSausage();
    }

    @Override
    public Chicken createChicken() {
        return new OldChicken();
    }
}
