package enumerated.menu;

import java.util.*;
import static enumerated.menu.Food.*;

/**
 * RUN:
 *         javac enumerated/menu/TypeOfFood.java && java enumerated.menu.TypeOfFood
 * OUTPUT:
 *         
 */

public class TypeOfFood {

    public static void main(String[] args) {
        Food food = Appetizer.SALAD;
        food = MainCourse.LASAGNE;
        food = Dessert.GELATO;
        food = Coffee.CAPPUCCINO;
    }
}