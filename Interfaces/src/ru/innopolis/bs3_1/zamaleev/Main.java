package ru.innopolis.bs3_1.zamaleev;

import ru.innopolis.bs3_1.zamaleev.pizzaMania.PizzaManiaPizzaStore;
import ru.innopolis.bs3_1.zamaleev.tatMak.TatMakPizzaStore;
import ru.innopolis.bs3_1.zamaleev.trapeza.TrapezaPizzaStore;

/**
 * Created by Ilgiz on 20.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        PizzaStore tatMak = new TatMakPizzaStore();
        tatMak.orderPizza(PizzaType.CHEESE);
        tatMak.orderPizza(PizzaType.CHICKEN);
        tatMak.orderPizza(PizzaType.PEPPERONI);

        PizzaStore pizzaMania = new PizzaManiaPizzaStore();
        pizzaMania.orderPizza(PizzaType.CHEESE);
        pizzaMania.orderPizza(PizzaType.CHICKEN);
        pizzaMania.orderPizza(PizzaType.PEPPERONI);

        PizzaStore trapeza = new TrapezaPizzaStore();
        trapeza.orderPizza(PizzaType.CHEESE);
        trapeza.orderPizza(PizzaType.CHICKEN);
        trapeza.orderPizza(PizzaType.PEPPERONI);
    }
}
