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

    private volatile boolean ligth = false;

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

    }

    class LightOff implements Runnable {
        
    }

    class WaterOn implements Runnable {

    }

    class WaterOff implements Runnable {
        
    }

    class ThermostatNight implements Runnable {

    }

    class ThermostatDay implements Runnable {
        
    }

    class Bell implements Runnable {
        
    }

    class Terminate implements Runnable {
        
    }
}