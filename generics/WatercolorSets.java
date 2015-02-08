package generics;

import generics.watercolors.*;
import java.util.*;
import static net.mindview.util.Sets.*;
import static generics.watercolors.Watercolors.*;

/**
 * RUN:
 *         javac generics/WatercolorSets.java && java generics.WatercolorSets
 * OUTPUT:
 *         set01: [BRILLIANT_RED, CRIMSON, MAGENTA, ROSE_MADDER, VIOLET, CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE]
 *         set02: [CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE, COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE, SAP_GREEN, YELLOW_OCHRE, BURNT_SIENNA, RAW_UMBER, BURNT_UMBER]
 *         union(set01, set02): [PHTHALO_BLUE, ULTRAMARINE, VIRIDIAN_HUE, RAW_UMBER, PERMANENT_GREEN, CRIMSON, MAGENTA, ROSE_MADDER, SAP_GREEN, BURNT_SIENNA, COBALT_BLUE_HUE, YELLOW_OCHRE, BRILLIANT_RED, BURNT_UMBER, VIOLET, CERULEAN_BLUE_HUE]
 *         intersection(set01, set02): [ULTRAMARINE, PHTHALO_BLUE, VIRIDIAN_HUE, COBALT_BLUE_HUE, PERMANENT_GREEN, CERULEAN_BLUE_HUE]
 *         difference(set01, subset): [CRIMSON, MAGENTA, BRILLIANT_RED, VIOLET, ROSE_MADDER]
 *         difference(set02, subset): [SAP_GREEN, RAW_UMBER, BURNT_SIENNA, YELLOW_OCHRE, BURNT_UMBER]
 *         complement(set01, set02): [RAW_UMBER, CRIMSON, MAGENTA, ROSE_MADDER, SAP_GREEN, BURNT_SIENNA, YELLOW_OCHRE, BRILLIANT_RED, VIOLET, BURNT_UMBER]
 */

public class WatercolorSets {

    public static void main(String[] args) {
        Set<Watercolors> set01 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set02 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);

        System.out.println("set01: " + set01);
        System.out.println("set02: " + set02);
        
        System.out.println("union(set01, set02): " + union(set01, set02));

        Set<Watercolors> subset = intersection(set01, set02);
        System.out.println("intersection(set01, set02): " + subset);

        System.out.println("difference(set01, subset): " + difference(set01, subset));
        System.out.println("difference(set02, subset): " + difference(set02, subset));
        System.out.println("complement(set01, set02): "  + complement(set01, set02));
    }
}