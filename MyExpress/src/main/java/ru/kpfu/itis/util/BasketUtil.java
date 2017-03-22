package ru.kpfu.itis.util;

import java.util.ArrayList;
import java.util.List;

public class BasketUtil {

    private List<ItemId> items;

    public BasketUtil(List<ItemId> items) {
        this.items = items;
    }

    public BasketUtil() {
        this.items = new ArrayList<>();
    }

    public void addItemId(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.get(i).countInc();
                return;
            }
        }

        items.add(new ItemId(id, 1));
    }

    public void removeItemId(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) items.remove(i);
        }
    }

    public void clear() {
        items.clear();
    }

    public List<ItemId> getAllId() {
        return items;
    }

    public class ItemId {

        private long id;
        private int count;

        public ItemId(long id, int count) {
            this.count = count;
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public int getCount() {
            return count;
        }

        public void countInc() {
            count++;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public boolean setItemCountByID(long id, int count) {
        for (ItemId itemId : items) {
            if (itemId.getId() == id) {
                itemId.setCount(count);
                return true;
            }
        }
        return false;
    }
}
