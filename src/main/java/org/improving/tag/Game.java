package org.improving.tag;

import org.improving.tag.commands.*;
import org.improving.tag.items.MonetaryItems;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import javax.naming.Name;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Game {
    private Command[] commands;
    private Date startTime;
    private Date endTime;
    private InputOutput io;
    private Player p;
    private Location startingLocation;
    private List<Location> locationList = new ArrayList<>();
    private final SaveGameFactory saveFactory;
    private ExitCommand exitCommand;

    // constructors
    public Game(Command[] commands, InputOutput io, SaveGameFactory saveFactory, WorldBuilder worldBuilder) {
        startingLocation = worldBuilder.buildWorld();
        locationList = worldBuilder.getLocationList();
        this.commands = commands;
        this.io = io;
        this.p = new Player(startingLocation);
        this.saveFactory = saveFactory;
        this.exitCommand = exitCommand;
    }


    public Location getStartingLocation() {
        return startingLocation;
    }

    public Player getPlayer() {
        return p;
    }

    public Date getStartTime() {
        return startTime;
    }

    private void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void run() {
        this.setStartTime(new Date());

        boolean loop = true;
        while (loop) {
            try {
                io.displayPrompt("> ");
                String input = io.receiveInput();

                Command validCommand = getValidCommand(input);
                if (null != validCommand) {
                    validCommand.execute(input, this);
                } else {
                    io.displayText("You good? I didn't quite get that..");
                }
            } catch (GameExitException ex) {
                loop = false;
            }
        }
        this.setEndTime(new Date());
    }

    private Command getValidCommand(String input) {
        return Stream.of(commands).filter(command -> command.
                isValid(input, this)).findFirst().orElse(null);
    }


    public Location getLocationOf(String intendedLocationName) {
        for (Location location : locationList) {
            if (intendedLocationName.equalsIgnoreCase(location.getName())) {
                return location;
            }
        }
        return null;
    }
}



