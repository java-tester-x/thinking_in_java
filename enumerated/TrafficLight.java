package enumerated;

import java.util.*;

/**
 * RUN:
 *         javac enumerated/TrafficLight.java && java enumerated.TrafficLight
 * OUTPUT:
 *         The traffic light is RED
 *         The traffic light is GREEN
 *         The traffic light is YELLOW
 *         The traffic light is RED
 *         The traffic light is GREEN
 *         The traffic light is YELLOW
 *         The traffic light is RED
 */

// enum Signal { GREEN, YELLOW, RED }
import static enumerated.Signal.*;

public class TrafficLight {

    Signal color = RED;

    public void change() {
        switch(color) {
            case RED:
                color = GREEN;
                break;
            case GREEN:
                color = YELLOW;
                break;
            case YELLOW:
                color = RED;
                break;
        }
    }

    public String toString() {
        return String.format("The traffic light is %1$s", color);
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}