package ru.innopolis.bs3_1.zamaleev.trapeza;

import ru.innopolis.bs3_1.zamaleev.IngredientFactory;
import ru.innopolis.bs3_1.zamaleev.ingredients.*;
import ru.innopolis.bs3_1.zamaleev.ingredients.impl.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class TrapezaIngredientFactory implements IngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new RussianCheese();
    }

    @Override
    public List<Veggie> createVeggies() {
        List<Veggie> veggies = new ArrayList();
        veggies.add(new Onion());
        veggies.add(new Tomato());
        veggies.add(new Cucumber());
        veggies.add(new Mushroom());
        veggies.add(new Olive());
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Chicken createChicken() {
        return new FreshChicken();
    }
}
