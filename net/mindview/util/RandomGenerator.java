package net.mindview.util;

import java.util.*;

public class RandomGenerator {

    private static Random rand = new Random(47);

    public static class Boolean implements Generator<java.lang.Boolean> {
        public java.lang.Boolean next() {
            return rand.nextBoolean();
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        public java.lang.Byte next() {
            return (byte)rand.nextInt();
        }
    }

    public static class Character implements Generator<java.lang.Character> {
        public java.lang.Character next() {
            return CountingGenerator.chars[rand.nextInt(CountingGenerator.chars.length)];
        }
    }

    public static class String extends CountingGenerator.String {
        
        { cg = new Character(); }

        public String() {}

        public String(int length) { super(length); }
    }

    public static class Short implements Generator<java.lang.Short> {
        public java.lang.Short next() {
            return (short)rand.nextInt();
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {
        
        private int mod = 10000;

        public Integer() {}

        public Integer(int modulo) { mod = modulo; }

        public java.lang.Integer next() {
            return rand.nextInt(mod);
        }
    }

    public static class Long implements Generator<java.lang.Long> {
        
        private int mod = 10000;

        public Long() {}

        public Long(int modulo) { mod = modulo; }

        public java.lang.Long next() {
            return new java.lang.Long(rand.nextInt(mod));
        }
    }

    public static class Float implements Generator<java.lang.Float> {
        public java.lang.Float next() {
            int trimmed = Math.round(rand.nextFloat() * 100);
            return ((float)trimmed) / 100;
        }
    }

    public static class Double implements Generator<java.lang.Double> {
        public java.lang.Double next() {
            long trimmed = Math.round(rand.nextDouble() * 100);
            return ((double)trimmed) / 100;
        }
    }
}