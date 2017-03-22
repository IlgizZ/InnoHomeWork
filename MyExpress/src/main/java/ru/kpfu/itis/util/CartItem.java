package ru.kpfu.itis.util;

import ru.kpfu.itis.model.Item;

public class CartItem{

    private Item item;
    private int count;

    public CartItem(Item item, int count) {
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }
}