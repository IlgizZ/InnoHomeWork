package ru.innopolis.bs3_1.zamaleev;

import ru.innopolis.bs3_1.zamaleev.ingredients.*;

import java.util.List;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public interface IngredientFactory {
    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    List<Veggie> createVeggies();

    Pepperoni createPepperoni();

    Chicken createChicken();
}
