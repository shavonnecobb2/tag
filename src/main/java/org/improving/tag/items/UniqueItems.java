package org.improving.tag.items;

import java.util.ArrayList;

public enum UniqueItems implements Item {
    GOLDEN_RING("A Golden Ring with Huge Diamonds", "Golden Ring"),
    BLUE_SHELL("A Blue Shell with Glittery Stripes", "Blue Shell"),
    PINK_POTION("A Pink Fizzy Potion", "Pink Potion"),
    SPARKLING_TIARA("A Sparkling Tiara", "Sparkling Tiara"),
    CHEWY_COOKIE("A Deliciously Warm Snickerdoodle Cookie", "Chewy Cookie"),
    PINK_SOCK("A Super Cute Pink Sock", "Pink Sock"),
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
