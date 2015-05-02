package enumerated.menu;

import java.util.*;

/**
 * RUN:
 *         javac enumerated/menu/Meal.java && java enumerated.menu.Meal
 * OUTPUT:
 *         SPRING_ROLLS
 *         VINDALOO
 *         FRUIT
 *         DECAF_COFFEE
 *         -------
 *         SOUP
 *         VINDALOO
 *         FRUIT
 *         TEA
 *         -------
 *         SALAD
 *         BURRITO
 *         FRUIT
 *         TEA
 *         -------
 *         SALAD
 *         BURRITO
 *         CREME_CARAMEL
 *         LATTE
 *         -------
 *         SOUP
 *         BURRITO
 *         TIRAMISU
 *         ESPRESSE
 *         -------
 *                  
 */

public class Meal {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("-------");
        }
    }
}