package exceptions;

/**
 * RUN:
 *         javac exceptions/StormyInning.java && java exceptions.StormyInning
 * OUTPUT:
 *         
 */

// import java.util.logging.*;
// import java.io.*;


public class StormyInning extends Inning implements Storm {

    public StormyInning() throws RainedOut, BaseballException {}

    public StormyInning(String s) throws Foul, BaseballException {}

    // Error: walk() in StormyInning cannot override walk() in Inning
    // 
    // 1) attempting to assign weaker access privileges; was public 
    // 2) overridden method does not throw PopFoul
    // 
    // void walk() throws PopFoul {}

    // Error: event() in StormyInning cannot override event() in Inning
    // 
    // 1)  overridden method does not throw RainedOut
    // 
    // public void event() throws RainedOut {}

    public void rainHard() throws RainedOut {}

    // without "throws BaseballException"
    public void event() {}

    // atBat() in Inning class throws Strike, Foul !!!
    public void atBat() throws PopFoul {}

    public static void main(String[] args)
    {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        }
        catch(PopFoul e) {
            System.out.println("Pop foul");
        }
        catch(RainedOut e) {
            System.out.println("Rained out");
        }
        catch(BaseballException e) {
            System.out.println("Common exception");
        }

        try {
            Inning i = new StormyInning();
            i.atBat();
        }
        catch(Strike e) {
            System.out.println("Strike");
        }
        catch(Foul e) {
            System.out.println("Foul");
        }
        catch(RainedOut e) {
            System.out.println("Rained out");
        }
        catch(BaseballException e) {
            System.out.println("Common exception");
        }
    }
}

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
    public Inning() throws BaseballException {}
    
    public void event() throws BaseballException {}

    public abstract void atBat() throws Strike, Foul;

    public void walk() {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}