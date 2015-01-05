package holding;

/**
 * RUN:
 *         javac holding/ListFeatures.java && java holding.ListFeatures
 * OUTPUT:
 *         1: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]
 *         2: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Hamster]
 *         3: true
 *         4: Cymric 2
 *         5: -1
 *         6: false
 *         7: true
 *         8: [Rat, Manx, Mutt, Pug, Cymric, Pug]
 *         9: [Rat, Manx, Mutt, Mouse, Pug, Cymric, Pug]
 *         subList: [Manx, Mutt, Mouse]
 *         10: true
 *         sorted subList: [Manx, Mouse, Mutt]
 *         11: true
 *         shuffled subList: [Mouse, Manx, Mutt]
 *         12: true
 *         sub: [Mouse, Pug]
 *         13: [Mouse, Pug]
 *         14: [Rat, Mouse, Mutt, Pug, Cymric, Pug]
 *         15: [Rat, Mutt, Cymric, Pug]
 *         16: [Rat, Mouse, Cymric, Pug]
 *         17: [Rat, Mouse, Mouse, Pug, Cymric, Pug]
 *         18: false
 *         19: []
 *         20: true
 *         21: [Manx, Cymric, Rat, EgyptianMau]
 *         22: EgyptianMau
 *         23: 14
 */

import java.util.*;

public class ListFeatures {
    
    public static void main(String[] args)
    {
        Random rand = new Random(47);

        Pets aPets = new Pets();
        List<Pet> pets = aPets.arrayList(7);
        System.out.println("1: "+ pets);

        Hamster h = new Hamster();
        pets.add(h);
        System.out.println("2: "+ pets);

        System.out.println("3: "+ pets.contains(h));

        pets.remove(h);
        Pet p = pets.get(2);
        System.out.println("4: "+ p + " " + pets.indexOf(p));

        Pet cymric = new Cymric();
        System.out.println("5: "+ pets.indexOf(cymric));

        System.out.println("6: "+ pets.remove(cymric));
        
        System.out.println("7: "+ pets.remove(p));
        
        System.out.println("8: "+ pets);

        pets.add(3, new Mouse());
        System.out.println("9: "+ pets);

        List<Pet> sub = pets.subList(1, 4);
        System.out.println("subList: "+ sub);

        System.out.println("10: "+ pets.containsAll(sub));

        Collections.sort(sub);
        System.out.println("sorted subList: "+ sub);
        System.out.println("11: "+ pets.containsAll(sub));

        Collections.shuffle(sub, rand);
        System.out.println("shuffled subList: "+ sub);
        System.out.println("12: "+ pets.containsAll(sub));

        List<Pet> copy = new ArrayList<Pet>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub: "+ sub); //sub: [Mouse, Pug]  - why?

        copy.retainAll(sub);
        System.out.println("13: "+ copy);

        copy = new ArrayList<Pet>(pets);
        copy.remove(2);
        System.out.println("14: "+ copy);

        copy.removeAll(sub);
        System.out.println("15: "+ copy);

        copy.set(1, new Mouse());
        System.out.println("16: "+ copy);

        copy.addAll(2, sub);
        System.out.println("17: "+ copy);

        System.out.println("18: "+ pets.isEmpty());
        pets.clear();
        System.out.println("19: "+ pets);

        System.out.println("20: "+ pets.isEmpty());

        pets.addAll(aPets.arrayList(4));
        System.out.println("21: "+ pets);

        Object[] o = pets.toArray();
        System.out.println("22: "+ o[3]);

        Pet[] pa = pets.toArray(new Pet[0]);
        System.out.println("23: "+ pa[3].id());

    }
}


class Pets {

    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
    
    private static String[] typeNames = { 
        "holding.Mutt",
        "holding.Pug",
        "holding.EgyptianMau",
        "holding.Manx",
        "holding.Cymric",
        "holding.Rat",
        "holding.Mouse",
        "holding.Hamster"
    };
     
    @SuppressWarnings("unchecked")
    private static void loader()
    { 
        try {
            for(String name : typeNames) {
                types.add((Class<? extends Pet>)Class.forName(name)); 
            }
        }   
        catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    static {
        loader();
    }

    public List<Class<? extends Pet>> getTypes() {
        return types;
    }

    private Random rand = new Random(47); 
    
    public Pet randomPet()
    {
        int n = rand.nextInt(typeNames.length);
        try {
            return getTypes().get(n).newInstance();
        } 
        catch( InstantiationException e) {
            throw new RuntimeException(e);
        } 
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
     
    public Pet[] createArray(int size)
    {
        Pet[] result = new Pet[size];
        for (int i=0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }
     
    public ArrayList<Pet> arrayList(int size) 
    {
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}


class Pet extends Individual {
    public Pet(String name) { super(name); } 
    public Pet () { super(); } 
}

class Dog extends Pet {
    public Dog(String name) { super(name); } 
    public Dog() { super(); } 
}

class Cat extends Pet {
    public Cat(String name) { super(name); } 
    public Cat() { super();} 
}

class Rodent extends Pet {
     public Rodent(String name) { super(name); } 
    public Rodent() { super(); } 
}

class Pug extends Dog {
    public Pug(String name) { super(name); } 
    public Pug() { super(); } 
}

class Mutt extends Dog {
    public Mutt(String name) { super(name); } 
    public Mutt() { super(); } 
}

class EgyptianMau extends Cat { 
    public EgyptianMau(String name) { super(name); }
    public EgyptianMau() { super(); }
}

class Manx extends Cat {
    public Manx(String name) { super(name); }
    public Manx() { super(); }
}

class Cymric extends Manx {
    public Cymric(String name) { super(name); } 
    public Cymric() { super(); } 
}

class Rat extends Rodent {
    public Rat(String name) { super(name); } 
    public Rat() { super(); }
}

class Mouse extends Rodent {
    public Mouse(String name) { super(name); }
    public Mouse() { super(); }
}

class Hamster extends Rodent {
    public Hamster(String name) { super(name); }
    public Hamster() { super(); } 
}

class Individual implements Comparable<Individual> {
    private static long counter = 0;
    private final long id = counter++;
    private String name;
    
    public Individual(String name) { this.name = name; }
   
    // 'name' is optional:
    public Individual() {}

    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }
    
    public long id() { return id; }
    
    public boolean equals(Object o) {
        return o instanceof Individual && id == ((Individual)o).id;
    }
    
    public int hashCode() {
        int result = 17;
        if(name != null) {
            result = 37 * result + name.hashCode();
        }
        result = 37 * result + (int)id;
        return result;
    }

    public int compareTo(Individual arg)
    {
        // Compare by class name first:
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        
        if(firstCompare != 0) {
            return firstCompare;
        }

        if(name != null && arg.name != null) {
            int secondCompare = name.compareTo(arg.name);
            if(secondCompare != 0) {
                return secondCompare;
            }
        }
        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }
}