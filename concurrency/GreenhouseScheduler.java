package concurrency;

import java.util.concurrent.*;
import java.util.*;


/**
 * RUN:
 *         javac concurrency/GreenhouseScheduler.java && java concurrency.GreenhouseScheduler
 *         
 * OUTPUT:
 *         
 */

public class GreenhouseScheduler {

    private volatile boolean light = false;

    private volatile boolean water = false;

    private String thermostat = "Day";

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String value) {
        thermostat = value;
    }

    ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);

    public void schedule(Runnable event, long delay) {
        scheduler.schedule(event, delay, TimeUnit.MILLISECONDS);
    }

    public void repeat(Runnable event, long initialDelay, long period) {
        scheduler.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    class LightOn implements Runnable {
        
        public void run() {
            // 
            // here must be code for microcontroller
            // 
            System.out.println("Light On");
            light = true;
        }
    }

    class LightOff implements Runnable {
        
        public void run() {
            // 
            // here must be code for microcontroller
            // 
            System.out.println("Light Off");
            light = false;
        }
    }

    class WaterOn implements Runnable {

        public void run() {
            // 
            // here must be code for microcontroller
            // 
            System.out.println("Water On");
            water = true;
        }
    }

    class WaterOff implements Runnable {
        
        public void run() {
            // 
            // here must be code for microcontroller
            // 
            System.out.println("Water Off");
            water = false;
        }
    }

    class ThermostatNight implements Runnable {

        public void run() {
            // 
            // here must be code for microcontroller
            // 
            System.out.println("Thermostat set in \"Night\" mode");
            setThermostat("Night");
        }
    }

    class ThermostatDay implements Runnable {
        
        public void run() {
            // 
            // here must be code for microcontroller
            // 
            System.out.println("Thermostat set in \"Day\" mode");
            setThermostat("Day");
        }        
    }

    class Bell implements Runnable {
        
        public void run() {
            System.out.println("B-A-A-M!");
        }
    }

    class Terminate implements Runnable {
        
        public void run() {
            System.out.println("Terminating");

            scheduler.shutdownNow();

            new Thread() {
                public void run() {
                    for (DataPoint d : data) {
                        System.out.println(d);
                    }
                }
            }.start();
        }
    }

    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar d, float temperature, float humidity) {
            this.time = d;
            this.temperature = temperature;
            this.humidity = humidity;
        }

        public String toString() {
            return time.getTime() + 
            String.format(" temperature: %1$.1f humidity: %2$.2f", temperature, humidity);
        }
    }

    private Calendar lastTime = Calendar.getInstance();
    {
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }

    private float  lastTemp          = 65.0f;
    private int    tempDirection     = +1;
    private float  lastHumidity      = 50.0f;
    private int    humidityDirection = +1;
    private Random rand              = new Random(47);

    List<DataPoint> data = Collections.synchronizedList(new ArrayList<DataPoint>());


    class CollectData implements Runnable {

        public void run() {
            System.out.println("Collecting data...");
            synchronized(GreenhouseScheduler.this) {
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);

                if (rand.nextInt(5) == 4) {
                    tempDirection = -tempDirection;
                }
                lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());

                if (rand.nextInt(5) == 4) {
                    humidityDirection = - humidityDirection;
                }
                lastHumidity = lastHumidity + humidityDirection * rand.nextFloat();

                data.add(new DataPoint((Calendar)lastTime.clone(), lastTemp, lastHumidity));
            }
        }
    }


    public static void main(String[] args) {
        GreenhouseScheduler gh = new GreenhouseScheduler();
        gh.schedule(gh.new Terminate(), 5000);
        gh.repeat(gh.new Bell(), 0, 1000);
        gh.repeat(gh.new ThermostatNight(), 0, 2000);
        gh.repeat(gh.new LightOn(), 0, 200);
        gh.repeat(gh.new LightOff(), 0, 400);
        gh.repeat(gh.new WaterOn(), 0, 600);
        gh.repeat(gh.new WaterOff(), 0, 800);
        gh.repeat(gh.new ThermostatDay(), 0, 1400);
        gh.repeat(gh.new CollectData(), 500, 500);
    }
}