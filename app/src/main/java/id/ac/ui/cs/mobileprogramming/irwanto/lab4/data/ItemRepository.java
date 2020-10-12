package id.ac.ui.cs.mobileprogramming.irwanto.lab4.data;

import java.util.Arrays;
import java.util.HashMap;

import id.ac.ui.cs.mobileprogramming.irwanto.lab4.model.Item;

public class ItemRepository {
    private HashMap<String, Item> items;

    public String[] getItemList() {
        if (items == null) createDummyItem();
        String[] keyArray = items.keySet().toArray(new String[items.size()]);
        Arrays.sort(keyArray);
        return keyArray;
    }

    public Item getItem(String name) {
        if (items == null) createDummyItem();
        return items.get(name);
    }

    public void createDummyItem() {
        items = new HashMap<String, Item>();
        for (int i = 1; i <= 20; i++) {
            String name = String.format("Item %02d", i);
            String desc = "Description of item " + i;
            items.put(name, new Item(name, desc));
        }
    }
}
