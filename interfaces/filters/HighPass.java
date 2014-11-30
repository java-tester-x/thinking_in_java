package interfaces.filters;

import java.util.*;

public class HighPass extends Filter {

    double cutoff;
    
    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    public String name() {
         return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input; // Pseudo process
    }
}
