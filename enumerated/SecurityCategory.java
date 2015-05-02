package enumerated;


import java.util.*;
import net.mindview.util.*;


/**
 * RUN:
 *         javac enumerated/SecurityCategory.java && java enumerated.SecurityCategory
 * OUTPUT:
 *         BOUND: MUNICIPAL
 *         BOUND: MUNICIPAL
 *         STOCK: MARGIN
 *         STOCK: MARGIN
 *         BOUND: JUNK
 *         STOCK: SHORT
 *         STOCK: LONG
 *         STOCK: LONG
 *         BOUND: MUNICIPAL
 *         BOUND: JUNK
 */

enum SecurityCategory {

    STOCK(Security.Stock.class),
    BOUND(Security.Bond.class);

    Security[] values;

    SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }

    interface Security {
        
        enum Stock implements Security { SHORT, LONG, MARGIN }

        enum Bond implements Security { MUNICIPAL, JUNK }
    }

    public Security randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + ": " + category.randomSelection());
        }
    }
} 