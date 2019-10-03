package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreasureChest {
    public static final TreasureChest NO_TREASURE = new TreasureChest("", UniqueItems.NOTHING);
    private final String description;
    private final List<Item> treasureChestItems = new ArrayList<>();

    public TreasureChest(String description, Item... item) {
        this.treasureChestItems.addAll(Arrays.asList(item));
        this.description = description;
    }

    public List getItem() {
        return this.getTreasureChestItems();
    }

    @Override
    public String toString() {
        return description;
    }

    public List<Item> getTreasureChestItems() {
        return treasureChestItems;
    }
//    public String getTreasureChestDisplay() {
//        String displayString = "You have these item(s): ";
//        treasureChestItems.sort(new ItemComparator());
//        for (Item item : treasureChestItems) {
//            displayString += "\n" + item;
//        }
//        return displayString;
//    }
}
