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
        Item item1 = new Item("Item 1", "Description of item 1");
        Item item2 = new Item("Item 2", "Description of item 2");
        Item item3 = new Item("Item 3", "Description of item 3");
        items.put("Item 1", item1);
        items.put("Item 2", item2);
        items.put("Item 3", item3);
    }
}
