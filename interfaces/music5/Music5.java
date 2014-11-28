package interfaces.music5;

import  polymorphism.music.Note;

/**
 * RUN:
 *     javac interfaces/music5/Music5.java && java interfaces.music5.Music5
 *
 * OUTPUT:
 * 
 *     Wind.play() MIDDLE_C
 *     Percussion.play() MIDDLE_C
 *     Stringed.play() MIDDLE_C
 *     Brass.play() MIDDLE_C
 *     Woodwind.play() MIDDLE_C
 */
public class Music5 {

    static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        Instrument[] orchestra = {
            new Wind(),
            new Percussion(),
            new Stringed(),
            new Brass(),
            new Woodwind()
        };

        tuneAll(orchestra);
    }
}

interface Instrument {

    int VALUE = 5; // it's STATIC and FINAL !!!

    // both methods are PUBLIC
    void play(Note n); 
    void adjust();
}

class Wind implements Instrument {

    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }

    public String toString() {
        return "Wind";
    }

    public void adjust() {
        System.out.println(this + ".adjust()");
    }  
}

class Percussion implements Instrument {

    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }

    public String toString() {
        return "Percussion";
    }

    public void adjust() {
        System.out.println(this + ".adjust()");
    } 
}

class Stringed implements Instrument {

    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }

    public String toString() {
        return "Stringed";
    }

    public void adjust() {
        System.out.println(this + ".adjust()");
    }
}

class  Brass extends Wind {

    public String toString() {
        return "Brass";
    }
}

class  Woodwind extends Wind {

    public String toString() {
        return "Woodwind";
    }
}