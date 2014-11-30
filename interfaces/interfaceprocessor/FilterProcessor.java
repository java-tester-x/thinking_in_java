package interfaces.interfaceprocessor;

import java.util.*;

import interfaces.filters.*;

/**
 * RUN:
 *         javac interfaces/interfaceprocessor/FilterProcessor.java && java interfaces.interfaceprocessor.FilterProcessor
 * OUTPUT:
 *         Using Processor LowPass
 *         Waveform 0
 *         Using Processor HighPass
 *         Waveform 0
 *         Using Processor BandPass
 *         Waveform 0
 */

public class FilterProcessor {

    public static void main(String[] args) {
        Waveform w = new Waveform();

        Apply.process(new FilterAdapter(new LowPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w);
        Apply.process(new FilterAdapter(new BandPass(1.0, 2.0)), w);
    }
}

class FilterAdapter implements Processor {

    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    public String name() {
        return filter.name();
    }

    public Waveform process(Object input) {
        return filter.process((Waveform)input);
    }
}