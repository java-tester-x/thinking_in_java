package enumerated;

import java.util.*;
import net.mindview.util.*;
import static enumerated.Input.*;


/**
 * RUN:
 *         javac enumerated/VendingMachine.java && java enumerated.VendingMachine
 * OUTPUT:
 *         
 */

enum Category {
    MONEY (NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION (TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION (ABORT_TRANSACTION),
    SHUT_DOWN (STOP);

    private Input[] values;

    Category(Input...types) { values = types; }

    private static EnumMap<Input, Category> categories = new EnumMap<Input, Category>(Input.class);

    static {
        for (Category c : Category.class.getEnumConstants()) {
            for (Input type : c.values()) {
                categories.put(type, c);
            }
        }
    }

    public static Category categorize(Input input) {
        return categories.get(input);
    }
}

public class VendingMachine {

    private static State state = State.RESTING;
    
    private static int amount = 0;
    
    private static Input selection = null;

    enum StateDuration { TRANSIENT }

    enum State {
        RESTING {
            void next(Input input) {
                switch(Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {
            void next() {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount()) {
                            System.out.println("Insufficient money for " + selection);
                        }
                        else {
                            state = DISPENSING;
                        }
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        DISPENSING (StateDuration.TRANSIENT) {
            void next() {

            }
        },
        GIVING_CHANGE (StateDuration.TRANSIENT) {
            void next() {

            }
        },
        TERMINAL {
            void output() {
                System.out.println("Halted");
            }
        };
    }

}