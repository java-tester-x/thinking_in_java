package enumerated;

import java.util.*;

/**
 * RUN:
 *         javac enumerated/OzWitch.java && java enumerated.OzWitch
 * OUTPUT:
 *         WEST: Miss Culch, aka the Wicked Witch of the West
 *         NORTH: Clinda, the Good Witch of the North
 *         EAST: Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house
 *         SOUTH: Good by inference, but missing
 */

public enum OzWitch {

    WEST("Miss Culch, aka the Wicked Witch of the West")
,   NORTH("Clinda, the Good Witch of the North")
,   EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house")
,   SOUTH("Good by inference, but missing");

    private String description;

    // constructor MUST BE package or private access:
    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() { return description; }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + ": " + witch.getDescription());
        }

        System.out.println(OzWitch.WEST);
    }
}