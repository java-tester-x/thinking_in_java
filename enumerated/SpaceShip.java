package enumerated;

import java.util.*;

/**
 * RUN:
 *         javac enumerated/SpaceShip.java && java enumerated.SpaceShip
 * OUTPUT:
 *         Scout
 *         Cargo
 *         Transport
 *         Cruiser
 *         Battleship
 *         Mothership
 */

public enum SpaceShip {

    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (SpaceShip s : SpaceShip.values()) {
            System.out.println(s + ": " + s.ordinal());
        }
    }
}