package enumerated.menu;

import java.util.*;
import net.mindview.util.*;

/**
 * RUN:
 *         javac enumerated/menu/Course.java 
 * OUTPUT:
 *
 */

public enum Course {

    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;

    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
}