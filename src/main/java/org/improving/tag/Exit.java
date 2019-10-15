package org.improving.tag;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity(name = "exits")
public class Exit {

    @Id
    long id;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "DestinationId")
    private Location destination;

    @Transient
    private List<String> aliases = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "OriginId")
    private Location origin;

    public Exit() {
    }

    public Exit(String name, Location destination, String... aliases) {
        this.name = name;
        this.destination = destination;
        this.aliases.addAll(Arrays.asList(aliases));
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void addAlias(String alias) {
        this.aliases.add(alias);
    }


    @Column(name = "Aliases")
    private String csvAliases;
    @PostLoad
    public void postLoad() {
        if (null != csvAliases) {
                Arrays.stream(csvAliases.replace(" ", "").split(",")).forEach(alias -> aliases.add(alias));
            }
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Exit) {
            Exit exit = (Exit) obj;
            return this.getName().equals(exit.getName()) &&
                    this.destination.equals(exit.getDestination());
        }
        return super.equals(obj);
    }
}
