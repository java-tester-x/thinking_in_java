package interfaces.filters;

import java.util.*;

public class Waveform {

    private static long counter;

    private final  long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
