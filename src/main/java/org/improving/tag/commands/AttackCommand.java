package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.TreasureChest;
import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

@Component
public class AttackCommand extends BaseAliasedCommand {
    private InputOutput io;
    private Random r;

    public AttackCommand(InputOutput io, Random random) {
        super(io, "attack", "a");
        this.io = io;
        this.r = r;
    }

    @Override
    public void execute(String input, Game game) {
        var adversary = game.getPlayer().getLocation().getAdversary();

        while (adversary == null) {
            io.displayText("...Attack what?");
            return;
        }
        if (adversary != null) {
            Random r = new Random();
            int x = r.nextInt(100) + 1;
            if (x <= 50) {
                io.displayText("Ayyeee! You just dealt 10 Damage to " + adversary.getName() + "!" +
                        "\n" + "Take that " + adversary.getName() + "!");
                adversary.setDamageTaken(adversary.getDamageTaken() + 10);
                adversary.setHitPoints(adversary.getHitPoints() - 10);
                io.displayText("Remaining Hit Points for " + adversary.getName() + ": " + adversary.getHitPoints());
            } else {
                io.displayText("Uh oh - you missed! Try again!");
            }

            var hp = adversary.getHitPoints();
            Item adversaryItem = game.getPlayer().getLocation().getAdversary().getAdversaryItem();
            if (hp <= 0) {
                io.displayText("\n" + "YAAAAASSSSS!! You just killed " + adversary.getName() + "!!!!");
                game.getPlayer().getInventory().addItem(adversaryItem);
                io.displayText("Look at that! " + adversary.getName() + " possessed a magical item - you lucky girl!!");
                io.displayText("You have added: " + adversaryItem + " to your inventory! Yeet yeet!!");
                game.getPlayer().getLocation().setAdversary(null);
            }
        }
    }
}
