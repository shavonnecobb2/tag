package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.MonetaryItems;

public class MoneyChest {
    public static final MoneyChest NO_MONEY = new MoneyChest(MonetaryItems.NOTHING, "");
    private final Item item;
    private final String description;

    public MoneyChest(Item item, String description) {
        this.item = item;
        this.description = description;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        return description;
    }
}
