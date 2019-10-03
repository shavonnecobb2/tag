package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public Inventory() {
        items.add(UniqueItems.CHEWY_COOKIE);
        items.add(UniqueItems.PINK_SOCK);
    }


    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addAll(List items) {
        this.items.addAll(items);
    }

    public String getInventoryDisplay() {
        String displayString = "These are the items you possess:";
        return items.stream().sorted(new ItemComparator()).map(item -> "\n" + item).
                reduce(displayString, (answer, itemValue) -> answer+= itemValue);

    }
}

