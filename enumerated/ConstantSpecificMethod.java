package enumerated;

import java.util.*;
import java.text.*;


/**
 * RUN:
 *         javac enumerated/ConstantSpecificMethod.java && java enumerated.ConstantSpecificMethod
 * OUTPUT:
 *         May 3, 2015
 *         null
 *         1.7.0_45
 */

public enum ConstantSpecificMethod {

    DATE_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },

    CLASSPATH {
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },

    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            System.out.println(csm.getInfo());
        }
    }

}