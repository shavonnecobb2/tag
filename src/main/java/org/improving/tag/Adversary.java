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
    Long id;

    @Column( name = "Name")
    private String name = "Sauron";

    @Column( name = "HitPoints" )
    private Integer hitPoints = 100;

    @Column( name = "DamageTaken" )
    private Long damageTaken;

    @Column( name = "AttackDamage" )
    private Long attackDamage;

    @Transient
    private TreasureChest treasureChest = new TreasureChest("A Blue Shell with Glittery Stripes", UniqueItems.BLUE_SHELL);

//    getters && setters


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

    public Long getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(Long damageTaken) {
        this.damageTaken = damageTaken;
    }

    public Long getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(long attackDamage) {
        this.attackDamage = attackDamage;
    }

    public List getAdversaryItem() {
        return treasureChest.getItem();
    }

}
