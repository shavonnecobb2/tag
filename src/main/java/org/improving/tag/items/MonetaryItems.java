package org.improving.tag.items;

public enum MonetaryItems implements Item {
    GOLD_COIN("A rugged gold coin", "Gold Coin", 10),
    SILVER_COIN("A shiny silver coin", "Silver Coin", 5),
    RUBY_GEM("A sparkling red gem", "Ruby Gem", 200),
    SAPPHIRE_GEM("A bright blue gem", "Sapphire Gem", 250),
    EMERALD_GEM("A mysteriously green gem", "Emerald Green", 400),
    NOTHING("", "", 0);

    private final String description;
    private final String name;
    private final int value;

    MonetaryItems(String description, String name, Integer value) {
        this.description = description;
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name + ": " + description + " worth " + value + " credits";
    }

    @Override
    public String getName() {
        return name;
    }
}





