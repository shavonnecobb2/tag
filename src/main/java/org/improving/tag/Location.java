package org.improving.tag;

import org.improving.tag.items.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "location")
public class Location {
    @Id
    private Long id;

    @Column(name = "Name")
    private String name = "";

    @Column(name = "Description")
    private String description = "";

    @OneToMany(mappedBy = "origin")
    private List<Exit> exits = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "AdversaryId")
    private Adversary adversary;

    @Transient
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE;


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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


    public List<Exit> getExits() {
        return exits;
    }

    public void addExit(Exit exit) {
        this.exits.add(exit);
    }

    public String getTreasureDescription() {
        return treasureChest.toString();
    }

    public List<Item> openTreasureChest() {
        for (Item item : treasureChest.getTreasureChestItems()) {
            System.out.println("    " + item.getName());
        }
        if (this.getTreasureChest().equals(TreasureChest.NO_TREASURE)) {
            throw new UnsupportedOperationException();
        } else
        {
            List treasureItem = treasureChest.getTreasureChestItems();
            treasureChest = TreasureChest.NO_TREASURE;
            return treasureItem;
        }
    }

    public TreasureChest getTreasureChest() {
        return treasureChest;
    }


    public void setTreasureChest(TreasureChest treasureChest) {
        this.treasureChest = treasureChest;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location location = (Location) obj;
            return this.getName().equals(location.getName()) &&
                    this.getDescription().equals(location.getDescription());
        }
        return super.equals(obj);
    }
}
