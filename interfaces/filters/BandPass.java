package interfaces.filters;

import java.util.*;

public class BandPass extends Filter {

    double lowCutoff;
    double highCutoff;
    
    public BandPass(double lowCut, double highCut) {
        this.lowCutoff  = lowCut;
        this.highCutoff = highCut;
    }

    public String name() {
         return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input; // Pseudo process
    }
}
