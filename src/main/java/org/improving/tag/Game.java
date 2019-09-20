package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.stereotype.Component;

import javax.naming.Name;
import java.util.Date;
import java.util.Scanner;

@Component
public class Game {
    private Command[] commands;
    private Date startTime;
    private Date endTime;

    // constructors
    public Game (Command[] commands) {
        this.commands = commands;
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
            Command validCommand = getValidCommand(input);
            if (null !=validCommand) {
                validCommand.execute(input);
            }
               else if (input.equals("exit")) {
                    System.out.println("Aw.. bye!");
                    loop = false;
                } else {
                    System.out.println("You good? I didn't quite get that silly girl.");
                }
            }
        this.setEndTime(new Date());
        }

    private Command getValidCommand(String input) {
        Command validCommand = null;
        for (Command command : commands) {
            if (command.isValid(input)) {
                return command;
            }
        }
        return null;
    }
}


