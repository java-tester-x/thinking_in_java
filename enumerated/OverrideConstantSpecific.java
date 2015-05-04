package enumerated;

import java.util.*;


/**
 * RUN:
 *         javac enumerated/OverrideConstantSpecific.java && java enumerated.OverrideConstantSpecific
 * OUTPUT:
 *         NUT: default behavior
 *         BOLT: default behavior
 *         WASHER: Overridden method
 */


public enum OverrideConstantSpecific {

    NUT, BOLT,
    WASHER {
        void f() { System.out.print("Overridden method"); }
    };

    void f() { System.out.print("default behavior"); }

    public static void main(String[] args) {
        for (OverrideConstantSpecific ocs : values()) {
            System.out.print(String.format("\n %1$s: ", ocs.toString()));
            ocs.f();
        }
    }
}