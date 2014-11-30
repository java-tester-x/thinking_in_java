package interfaces.filters;

import java.util.*;

public class LowPass extends Filter {

    double cutoff;
    
    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    public String name() {
         return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input; // Pseudo process
    }
}
