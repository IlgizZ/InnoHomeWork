package ru.innopolis.bs3_1.zamaleev.pizza;

import ru.innopolis.bs3_1.zamaleev.IngredientFactory;
import ru.innopolis.bs3_1.zamaleev.Pizza;
import ru.innopolis.bs3_1.zamaleev.ingredients.Veggie;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class PepperoniPizza extends Pizza {
    public PepperoniPizza(IngredientFactory ingredientFactory) {
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
        pepperoni = ingredientFactory.createPepperoni();
        pepperoni.makeAcute();
        veggies = ingredientFactory.createVeggies();
        veggies.forEach(Veggie::giveSpecificTaste);
    }
}
