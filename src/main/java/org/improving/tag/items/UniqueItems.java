package org.improving.tag.items;

import java.util.ArrayList;

public enum UniqueItems implements Item {
    GOLDEN_RING("A Golden Ring"),
    BLUE_SHELL("A Blue Shell with Glittery Stripes"),
    NOTHING("");


    private final String description;

    UniqueItems(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
