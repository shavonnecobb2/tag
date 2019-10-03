package org.improving.tag;

import org.improving.tag.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name = "";
    private String description = "";
    private List<String> tags = new ArrayList<>();
    private List<Exit> exits = new ArrayList<>();
    private Adversary adversary;
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE;
    private MoneyChest moneyChest = MoneyChest.NO_MONEY;



    public Adversary getAdversary() {
        return adversary;
    }
    public void setAdversary(Adversary adversary) {
        this.adversary = adversary;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<Exit> getExits() {
        return exits;
    }

    public String getTreasureDescription() {
        return treasureChest.toString();
    }

    public Item openTreasureChest () {
        if (TreasureChest.NO_TREASURE.equals(treasureChest)) {
            throw new UnsupportedOperationException();
        }
        Item treasureItem = treasureChest.getItem();
        treasureChest = TreasureChest.NO_TREASURE;
        return treasureItem;
    }

    public Item openMoneyChest () {
        if (MoneyChest.NO_MONEY.equals(moneyChest)) {
            throw new UnsupportedOperationException();
        }
        Item moneyItem = moneyChest.getItem();
        moneyChest = MoneyChest.NO_MONEY;
        return moneyItem;
    }

    public TreasureChest getTreasureChest() {
        return treasureChest;
    }
    public void setTreasureChest(TreasureChest treasureChest) {
        this.treasureChest = treasureChest;
    }

    public MoneyChest getMoneyChest() {
        return moneyChest;
    }
    public void setMoneyChest(MoneyChest moneyChest) {
        this.moneyChest = moneyChest;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location location = (Location)obj;
            return this.getName().equals(location.getName()) &&
                    this.getDescription().equals(location.getDescription());
        }
        return super.equals(obj);
    }
}
