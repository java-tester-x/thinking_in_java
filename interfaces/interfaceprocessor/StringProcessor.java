package interfaces.interfaceprocessor;

import java.util.*;

/**
 * RUN:
 *         javac interfaces/interfaceprocessor/StringProcessor.java && java interfaces.interfaceprocessor.StringProcessor
 * OUTPUT:
 *         Using Processor Upcase
 *         IF SHE WEIGHS THE SAME AS DUCK, SHE'S MADE OF WOOD
 *         Using Processor Downcase
 *         if she weighs the same as duck, she's made of wood
 *         Using Processor Splitter
 *         [If, she, weighs, the, same, as, duck,, she's, made, of, wood]
 */

public abstract class StringProcessor implements Processor {
    
    public String name() {
        return getClass().getSimpleName();
    }

    public abstract String process(Object input);

    public static String s = "If she weighs the same as duck, she's made of wood";

    public static void main(String[] args) {
        Apply.process(new Upcase(), s);
        Apply.process(new Downcase(), s);
        Apply.process(new Splitter(), s);
    }
}

class Upcase extends StringProcessor {

    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase extends StringProcessor {

    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends StringProcessor {

    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}
