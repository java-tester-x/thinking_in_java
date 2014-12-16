package innerclasses;

/**
 * RUN:
 *         javac innerclasses/Parcel6.java && java innerclasses.Parcel6
 * OUTPUT:
 *         
 */

public class Parcel6 {

    private void internalTracking(boolean b)
    {
        if (b) {
            
            class TrackingSlip {
                
                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() { return id; }
            }

            TrackingSlip ts = new TrackingSlip("waiting");
            String s = ts.getSlip();
        }

        // innerclasses\Parcel6.java:32: error: cannot find symbol
        //         TrackingSlip ts = new TrackingSlip("x");
        //         ^
        //   symbol:   class TrackingSlip
        //   location: class Parcel6
        // innerclasses\Parcel6.java:32: error: cannot find symbol
        //         TrackingSlip ts = new TrackingSlip("x");
        //                               ^
        //   symbol:   class TrackingSlip
        //   location: class Parcel6
        // 2 errors
        // 
        // TrackingSlip ts = new TrackingSlip("x");
    }

    public void track() { internalTracking(true); }    

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}