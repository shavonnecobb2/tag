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


//    private Location buildWorld() {
//        var tdh = new Location();
//        tdh.setName("The Deathly Hallows");
//        tdh.setTreasureChest(new TreasureChest("An invisible cloak with an object peeking out underneath.", UniqueItems.HARRYS_WAND));
//        this.locationList.add(tdh);
//
//        var td = new Location();
//        td.setName("The Desert");
//        this.locationList.add(td);
//        td.setTreasureChest(new TreasureChest("A glittering half-empty water jug.", UniqueItems.SPARKLING_TIARA));
//
//        var ta = new Location();
//        ta.setName("The Amazon");
//        this.locationList.add(ta);
//        ta.setTreasureChest(new TreasureChest("A small, red box under the trees.", MonetaryItems.RUBY_GEM));
//
//
//        var tmcs = new Location();
//        tmcs.setName("The Mac & Cheese Shop");
//        tmcs.setTreasureChest(new TreasureChest("A Kraft box sitting on the counter.", UniqueItems.GOLDEN_RING, MonetaryItems.SILVER_COIN));
//        this.locationList.add(tmcs);
//
//        var a = new Location();
//        a.setName("Airport");
//        a.setTreasureChest(new TreasureChest("A large brown suitcase resting on the arm of a chair.", MonetaryItems.EMERALD_GEM));
//        this.locationList.add(a);
//
//        var tict = new Location();
//        tict.setName("The Ice Cream Truck");
//        this.locationList.add(tict);
//
//        var tmo = new Location();
//        tmo.setName("The Mountains");
//        this.locationList.add(tmo);
//        // tmo.setTC(new TC("d", i1, i2, i3))
//        tmo.setTreasureChest(new TreasureChest("A black, velvet pouch sitting on the ground.", MonetaryItems.GOLD_COIN, MonetaryItems.SAPPHIRE_GEM));
//
//        var tma = new Location();
//        tma.setName("The Mall");
//        this.locationList.add(tma);
//
//        var md = new Location();
//        md.setName("Mount Doom");
//        this.locationList.add(md);
//        md.setAdversary(new Adversary());
//
//        var tvod = new Location();
//        tvod.setName("The Volcano of Death");
//        this.locationList.add(tvod);
//
//        var tr = new Location();
//        tr.setName("The Reef");
//        this.locationList.add(tr);
//
//        var tvm = new Location();
//        tvm.setName("The Velvet Moose");
//        this.locationList.add(tvm);
//        tvm.setTreasureChest(new TreasureChest("A large vial resting in the middle of the table.", UniqueItems.PINK_POTION));
//
//
//        tdh.getExits().add(new Exit("Heaven Ave", tmcs, "h", "ha", "heaven", "ave"));
//        tdh.getExits().add(new Exit("The Deathly Brownie", td, "tdb", "brownie", "death", "the"));
//        td.getExits().add(new Exit("Camel Path", ta, "cp", "camel", "path"));
//        td.getExits().add(new Exit("The Dock", a, "dock", "the", "d", "td"));
//        td.getExits().add(new Exit("Rocky Road", tict, "rocky", "road", "rr"));
//        tmcs.getExits().add(new Exit("Highway 121", ta, "121", "hwy 121", "h121"));
//        tmcs.getExits().add(new Exit("Paradise Rd", tr, "paradise", "rd", "road", "p road", "p", "pr"));
//        tmcs.getExits().add(new Exit("Highway 21", tvod, "hwy 21", "h21", "21"));
//        tvm.getExits().add(new Exit("The Front Door", ta, "front door", "front", "door", "fd", "tfd"));
//        tvm.getExits().add(new Exit("The Pudding Slide", a, "pudding slide", "pudding", "slide", "ps", "tps"));
//        a.getExits().add(new Exit("Flight to the Mall", tma, "to the mall", "mall", "f to mall", "fttm"));
//        a.getExits().add(new Exit("Flight 121", tmo, "121", "f121"));
//        tr.getExits().add(new Exit("The Scenic Route", tvm, "scenic", "route", "scenic route", "sr"));
//        tr.getExits().add(new Exit("The City Walk", tma, "city", "walk", "city walk", "cw"));
//        tict.getExits().add(new Exit("Magic Portal", md, "magic", "portal", "mp"));
//        tma.getExits().add(new Exit("An Escalator of Doom", tvod, "escalator of doom", "escalator", "ed"));
//        tma.getExits().add(new Exit("Path to Doom", md, "path doom", "path", "pd"));
//        md.getExits().add(new Exit("Jump into Lava", tvod, "lava", "jump lava", "jump"));
//        md.getExits().add(new Exit("The Cab", tma, "cab", "the", "tc"));
//        tmo.getExits().add(new Exit("Bike Trail", tr, "bike", "b", "bt"));
//        tmo.getExits().add(new Exit("The Plane", ta, "plane", "p", "tp"));
//        tmo.getExits().add(new Exit("The Narrow Trail", md, "narrow", "narrow trail", "tnt", "the narrow"));
//        tmo.getExits().add(new Exit("The Lava Flow", tvod, "lava", "flow", "lava flow", "lf", "tlf", "the lava"));
//        ta.getExits().add(new Exit("Amaz-ing Moose", tvm, "amazing", "amazing moose", "moose", "am", "amaze"));
//
//        return tdh;
//    }

    public Location getLocationOf(String intendedLocationName) {
        for (Location location : locationList) {
            if (intendedLocationName.equalsIgnoreCase(location.getName())) {
                return location;
            }
        }
        return null;
    }
}



