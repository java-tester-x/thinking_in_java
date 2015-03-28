package io;

import java.io.*;
import java.util.*;
import java.util.prefs.*;


/**
 * RUN:
 *         javac io/PreferencesDemo.java && java io.PreferencesDemo
 *         
 * OUTPUT:
 *         Location: Oz
 *         Footwear: Ruby Slippers
 *         Companions: 4
 *         Are there witches?: true
 *         UsageCount: 1
 *         How many companions does Doroty have? 4
 */

public class PreferencesDemo {

    public static void main(String[] args) throws Exception {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("Location", "Oz");
        prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?", true);

        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++;
        prefs.putInt("UsageCount", usageCount);

        for (String key: prefs.keys()) {
            System.out.println(key + ": " + prefs.get(key, null));
        }

        System.out.println("How many companions does Doroty have? "+
            prefs.getInt("Companions", 0)
        );
    }
}