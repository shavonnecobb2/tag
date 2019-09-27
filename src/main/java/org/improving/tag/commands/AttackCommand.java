package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

@Component
public class AttackCommand implements Command{
    private InputOutput io;
    private Random r;

    public AttackCommand(InputOutput io, Random random) {
        this.io = io;
        this.r = r;
    }

    @Override
    public boolean isValid(String input, Game game) {
        return input.trim().equalsIgnoreCase("attack");
    }

    @Override
    public void execute(String input, Game game) {
        var adversary = game.getPlayer().getLocation().getAdversary();

        while (adversary == null) {
            io.displayText("...Attack what?");
        }
        if (adversary != null) {
            Random r = new Random();
            int x = r.nextInt(100) + 1;
            if (x <= 20) {
                io.displayText("Woohoo! You have just dealt 10 Damage to Sauron!");
                adversary.setDamageTaken(adversary.getDamageTaken() + 10);
                adversary.setHitPoints(adversary.getHitPoints() - 10);
                io.displayText("Remaining Hit Points for Sauron: " + adversary.getHitPoints());
            } else {
                io.displayText("Dang it! You missed!");
            }
            }
        }
    }
