package org.improving.tag.commands;

import org.improving.tag.Game;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand implements Command{
    @Override
    public boolean isValid(String input, Game game) {
        return input.trim().equalsIgnoreCase("attack");
    }

    @Override
    public void execute(String input, Game game) {
        var adversary = game.getPlayer().getLocation().getAdversary();

        while (adversary == null) {
            System.out.println("...Attack what?");
        }
        if (adversary != null) {
            Random ran = new Random();
            int x = ran.nextInt(100) + 1;
            if (x <= 20) {
                System.out.println("Woohoo! You have just dealt 10 Damage to Sauron!");
                adversary.setDamageTaken(adversary.getDamageTaken() + 10);
                adversary.setHitPoints(adversary.getHitPoints() - 10);
                System.out.println("Remaining Hit Points for Sauron: " + adversary.getHitPoints());
            } else {
                System.out.println("Dang it! You missed!");
            }
            }
        }
    }
