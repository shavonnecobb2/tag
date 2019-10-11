package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.GameExitException;
import org.improving.tag.InputOutput;
import org.improving.tag.TreasureChest;
import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.List;
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
            int y = r.nextInt(100) +1;
            var playerStats = game.getPlayer();
            if (x <= 50) {
                io.displayText("You Attack - Ayyeee! You just dealt 10 Damage to " + adversary.getName() + "! Take that " + adversary.getName() + "!");
                adversary.setDamageTaken(adversary.getDamageTaken() + 10);
                adversary.setHitPoints(adversary.getHitPoints() - 10);
                io.displayText("     [Remaining Hit Points for " + adversary.getName() + ": " + adversary.getHitPoints() + "]");
                io.displayNewLine();
            } else {
                io.displayText("You Attack - You missed! Try again you big dummy!");
                io.displayNewLine();
            }
            if (y <= 55) {
                io.displayText("He Attacks - Dang it! " + adversary.getName() + " just dealt 10 Damage!");
                playerStats.setDamageTaken(playerStats.getDamageTaken() + 10);
                playerStats.setHitPoints(playerStats.getHitPoints() - 10);
                io.displayText("     [Your remaining Hit Points: " + playerStats.getHitPoints() + "]");
            } else {
                io.displayText("He Attacks - Whew lucky you! He missed!");
            }

            var adversaryHP = adversary.getHitPoints();
            var playerHP = game.getPlayer().getHitPoints();
            List adversaryItem = game.getPlayer().getLocation().getAdversary().getAdversaryItem();
            if (adversaryHP <= 0) {
                io.displayText("\n" + "YAAAAASSSSS!! You just killed " + adversary.getName() + "!!!!");
                game.getPlayer().getInventory().addAll(adversaryItem);
                io.displayText("Look at that! " + adversary.getName() + " possessed a magical item - you lucky girl!!");
                io.displayText("You have added: " + adversaryItem + " to your inventory! Yeet yeet!!");
                game.getPlayer().getLocation().setAdversary(null);
            } else {
                if (playerHP <= 0) {
                    io.displayNewLine();
                    io.displayText("Bummer.. " + adversary.getName() + " just killed you.. RIP my friend.");
                    throw new GameExitException();
                }
            }
        }
    }
}
