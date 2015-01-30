package typeinfo;  

import java.util.*;

/**
 * RUN:
 *         javac typeinfo/SnowRemovalRobot.java && java typeinfo.SnowRemovalRobot
 * OUTPUT:
 *         Name: Slusher
 *         Model: SnowBot Series 11
 *         Slusher can remove snow
 *         Slusher remove snow
 *         Slusher can crush ice
 *         Slusher crush ice
 *         Slusher can clean roof
 *         Slusher clean roof
 */

public class SnowRemovalRobot implements Robot {

    private String name;

    public SnowRemovalRobot(String name) { this.name = name; }

    public String name() { return name; }

    public String model() { return "SnowBot Series 11"; }

    public List<Operation> operations() {
        return Arrays.asList(
            new Operation() {

                public String description() {
                    return name + " can remove snow";
                }

                public void command() {
                    System.out.println(name + " remove snow");
                }
            }
        ,   new Operation() {

                public String description() {
                    return name + " can crush ice";
                }

                public void command() {
                    System.out.println(name + " crush ice");
                }
            }
        ,   new Operation() {

                public String description() {
                    return name + " can clean roof";
                }

                public void command() {
                    System.out.println(name + " clean roof");
                }
            }    
        );
    }

    public static void main(String[] args) {
        Robot.Test.test(new SnowRemovalRobot("Slusher"));
    }
}