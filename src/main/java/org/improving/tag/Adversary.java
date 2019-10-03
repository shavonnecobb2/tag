package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import java.util.List;

public class Adversary {
    private String name = "Sauron";
    private int hitPoints = 100;
    private int damageTaken;
    private int attackDamage;
    private TreasureChest treasureChest = new TreasureChest("A Blue Shell with Glittery Stripes", UniqueItems.BLUE_SHELL);


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public List getAdversaryItem() {
        return treasureChest.getItem();
    }

}
