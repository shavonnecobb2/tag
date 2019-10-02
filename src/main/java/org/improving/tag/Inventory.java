package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public Inventory() {
        items.add(UniqueItems.CHEWY_COOKIE);
        items.add(UniqueItems.SPARKLING_TIARA);
        items.add(UniqueItems.PINK_SOCK);
    }


    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getInventoryDisplay() {
        String displayString = "You have these item(s): ";
        items.sort(new ItemComparator());
        for (Item item : items) {
            displayString += "\n" + item;
        }
        return displayString;
    }
}
