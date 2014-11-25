package polymorphism;

import java.io.PrintStream;

class Cyrillic {
    public static void println(String s)
    {
        try {
            PrintStream ps = new PrintStream(System.out, true, "UTF-8");
            ps.println(s);
        }
        catch (java.io.UnsupportedEncodingException e) {
            System.out.println("Error");
        }        
    }
}

class Characteristic {

    private String s;

    Characteristic(String s) {
        this.s = s;
        // System.out.println("Create Characteristic " + s);
        Cyrillic.println("Создаем Characteristic " + s);
    }

    protected void dispose() {
        // System.out.println("Dispose Characteristic " + s);    
        Cyrillic.println("Завершаем Characteristic " + s);
    }
}

class Description {

    private String s;

    Description(String s) {
        this.s = s;
        Cyrillic.println("Создаем Description " + s);
    }

    protected void dispose() {
        Cyrillic.println("Завершаем Description " + s);    
    }
}

class LivingCreature {

    private Characteristic p = new Characteristic("живое существо");

    private Description    t = new Description("обычное живое существо");

    LivingCreature() {
        System.out.println("LivingCreature()");
    }

    protected void dispose() {
        System.out.println("dispose() in  LivingCreature");
        t.dispose();
        p.dispose();    
    }
}

class Animal extends LivingCreature {

    private Characteristic p = new Characteristic("имеет сердце");

    private Description    t = new Description("животное, не растение");

    Animal() {
        System.out.println("Animal()");
    }

    protected void dispose() {
        System.out.println("dispose() in  Animal");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}

class Amphibian extends Animal {

    private Characteristic p = new Characteristic("может жить в воде");

    private Description    t = new Description("и в воде, и на земле");

    Amphibian() {
        System.out.println("Amphibian()");
    }

    protected void dispose() {
        System.out.println("dispose() in  Amphibian");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}

public class Frog extends Amphibian {

    private Characteristic p = new Characteristic("квакает");

    private Description    t = new Description("ест жуков");

    Frog() {
        System.out.println("Frog()");
    }

    protected void dispose() {
        System.out.println("dispose() in  Frog");
        t.dispose();
        p.dispose();
        super.dispose();
    }


    public static void main(String[] args) {
        Frog frog = new Frog();
        System.out.println("Goodbye!");
        frog.dispose();
    }
}