package org.improving.tag.items;

import java.util.ArrayList;

public enum UniqueItems implements Item {
    GOLDEN_RING("A golden ring with huge diamonds", "Golden Ring"),
    BLUE_SHELL("A blue shell with glittery stripes", "Blue Shell"),
    PINK_POTION("A pink fizzy potion", "Pink Potion"),
    SPARKLING_TIARA("A sparkling tiara", "Sparkling Tiara"),
    CHEWY_COOKIE("A deliciously warm snickerdoodle cookie", "Chewy Cookie"),
    PINK_SOCK("A super cute pink sock", "Pink Sock"),
    HARRYS_WAND("A powerful wand etched with magic", "Harry Potter's Wand"),
    NOTHING("", "");


    private final String description;
    private final String name;

    UniqueItems(String description, String name) {
        this.description = description;
        this.name = name;
    }

    @Override
    public String toString() {
       return name + ": " + description;
    }

    @Override
    public String getName() {
        return name;
    }
}
