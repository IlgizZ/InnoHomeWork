package ru.innopolis.bs3_1.zamaleev.tatMak;

import ru.innopolis.bs3_1.zamaleev.IngredientFactory;
import ru.innopolis.bs3_1.zamaleev.ingredients.*;
import ru.innopolis.bs3_1.zamaleev.ingredients.impl.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class TatMakIngredientFactory implements IngredientFactory {

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new Ketchunnaise();
    }

    @Override
    public Cheese createCheese() {
        return new RubberStretchedCheese();
    }

    @Override
    public List<Veggie> createVeggies() {
        List<Veggie> list = new ArrayList();
        list.add(new Onion());
        list.add(new Tomato());
        return list;
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
