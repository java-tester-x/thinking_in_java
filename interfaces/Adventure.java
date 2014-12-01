package interfaces;

/**
 * RUN:
 *         javac interfaces/Adventure.java && java interfaces.Adventure
 * OUTPUT:
 *         ActionCharacter.fight()
 *         Hero.swim()
 *         Hero.fly()
 *         ActionCharacter.fight()
 */

public class Adventure {

    public static void t(CanFight x) {
        x.fight();
    }

    public static void u(CanSwim x) {
        x.swim();
    }

    public static void v(CanFly x) {
        x.fly();
    }

    public static void w(ActionCharacter x) {
        x.fight();
    }

    public static void main(String[] args)
    {
        Hero h = new Hero();
        t(h);    
        u(h);    
        v(h);    
        w(h);    
    }
}

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {

    public void fight() { System.out.println("ActionCharacter.fight()"); }
}

class Hero  extends     ActionCharacter 
            implements  CanFight, CanSwim, CanFly  {

    // public void fight() { System.out.println("Hero.fight()"); }

    public void swim() { System.out.println("Hero.swim()"); }

    public void fly() { System.out.println("Hero.fly()"); }
}