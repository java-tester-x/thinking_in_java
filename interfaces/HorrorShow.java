package interfaces;

import java.util.*;

/**
 * RUN:
 *         javac interfaces/HorrorShow.java && java interfaces.HorrorShow
 * OUTPUT:
 *         DragonZilla menace()
 *         DragonZilla menace()
 *         DragonZilla destroy()
 *         VeryBadVampire menace()
 *         VeryBadVampire menace()
 *         VeryBadVampire destroy()
 *         VeryBadVampire kill()
 */

public class HorrorShow {

    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        DangerMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}

interface Monster {

    void menace();
}

interface DangerMonster extends Monster {

    void destroy();
}

interface Lethal {

    void kill();
}

class DragonZilla implements DangerMonster {

    public void menace() {
        System.out.println(getClass().getSimpleName()+" menace()");
    }

    public void destroy() {
        System.out.println(getClass().getSimpleName()+" destroy()");
    }
}

interface Vampire extends DangerMonster, Lethal {

    void drinkBlood();
}

class VeryBadVampire implements Vampire {

    public void menace() {
        System.out.println(getClass().getSimpleName()+" menace()");
    }

    public void destroy() {
        System.out.println(getClass().getSimpleName()+" destroy()");
    }

    public void kill() {
        System.out.println(getClass().getSimpleName()+" kill()");
    }

    public void drinkBlood() {
        System.out.println(getClass().getSimpleName()+" drinkBlood()");
    }
}