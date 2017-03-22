package ru.innopolis.bs3_1.zamaleev.pizza;

import ru.innopolis.bs3_1.zamaleev.IngredientFactory;
import ru.innopolis.bs3_1.zamaleev.Pizza;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class CheesePizza extends Pizza {

    public CheesePizza(IngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }

    @Override
    protected void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        dough.getCrunch();
        sauce = ingredientFactory.createSauce();
        sauce.giveSpecificTaste();
        cheese = ingredientFactory.createCheese();
        cheese.melt();
    }
}
