package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Entity( name = "adversary" )
public class Adversary {
    @Id
    long id;

    @Column( name = "Name")
    private String name = "Sauron";

    @Column( name = "HitPoints" )
    private int hitPoints = 100;

    @Column( name = "DamageTaken" )
    private int damageTaken;

    @Column( name = "AttackDamage" )
    private int attackDamage;

    @Transient
    private TreasureChest treasureChest = new TreasureChest("A Blue Shell with Glittery Stripes", UniqueItems.BLUE_SHELL);

//    getters && setters
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
