package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity( name = "adversary" )
public class Adversary {
    @Id
    Long id;

    @Column(name = "Name")
    private String name = "Sauron";

    @Column(name = "HitPoints")
    private Integer hitPoints = 100;

    @Column(name = "DamageTaken")
    private Integer damageTaken = 0;

    @Column(name = "AttackDamage")
    private Integer attackDamage;

    //DELETE AFTER THIS MORNING
    @Column(name = "ForExercise")
    private UniqueItems uniqueItems = UniqueItems.CHEWY_COOKIE;
    //DELETE AFTER THIS MORNING

    @Transient
    private TreasureChest treasureChest = new TreasureChest("A Blue Shell with Glittery Stripes", UniqueItems.BLUE_SHELL);

//    getters && setters


    public UniqueItems getUniqueItems() {
        return uniqueItems;
    }

    public void setUniqueItems(UniqueItems uniqueItems) {
        this.uniqueItems = uniqueItems;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Integer getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(Integer damageTaken) {
        this.damageTaken = damageTaken;
    }

    public Integer getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(Integer attackDamage) {
        this.attackDamage = attackDamage;
    }

    public List getAdversaryItem() {
        return treasureChest.getItem();
    }

}


