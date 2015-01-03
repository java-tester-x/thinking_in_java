 package holding;

/**
 * RUN:
 *         javac holding/AsListInterface.java && java holding.AsListInterface
 * OUTPUT:
 *         [holding.Crusty@9931f5, holding.Slush@19ee1ac, holding.Powder@1f1fba0]
 *         [holding.Light@1befab0, holding.Heavy@13c5982]
 *         [holding.Light@1186fab, holding.Heavy@14b7453]
 */

import java.util.*;

public class AsListInterface {
    
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder() );
        System.out.println(snow1);

        // error: incompatible types
        // 
        // required: List<Snow>
        // found:    List<Powder>
        // List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());

        List<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3, new Light(), new Heavy());
        System.out.println(snow3);

        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());
        System.out.println(snow4);
    }
}

class Snow { }
class Powder extends Snow { }
class Light extends Powder { }
class Heavy extends Powder { }
class Crusty extends Snow { }
class Slush extends Snow { }
