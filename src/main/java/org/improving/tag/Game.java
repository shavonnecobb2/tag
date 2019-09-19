package org.improving.tag;

import javax.naming.Name;
import java.util.Date;
import java.util.Scanner;

public class Game {
    private Date startTime;
    private Date endTime;


    public Game(int maxInventory) {
        System.out.println("Ran the constructor, Maximum Inventory is " + maxInventory);
    }

    public Game(int maxInventory, int playerAge) {
        this(maxInventory);
        System.out.println("The player's age is " + playerAge);
    }



    public Date getStartTime() { return startTime; }
    private void setStartTime (Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime () {
        return endTime;
    }
    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        this.setStartTime(new Date());

        boolean loop = true;
        while(loop) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equals("look")) {
                System.out.println("You look around.");
            }
            else if (input.equals("inventory")) {
                System.out.println("You are carrying nothing.");
            } else if (input.equals("dance")) {
                System.out.println("You dance around.");
            } else if (input.equals("jump")) {
                System.out.println("You jump in the air.");
            } else if (input.equals("exit")) {
                System.out.println("Goodbye.");
                loop = false;
            } else {
                System.out.println("Huh? I didn't quite get that silly girl.");
            }
        }
        this.setEndTime(new Date());
    }
}


