package typeinfo.pets;

import java.util.*;

public class Pets {

    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
    
    private static String[] typeNames = { 
        "typeinfo.pets.Mutt",
        "typeinfo.pets.Pug",
        "typeinfo.pets.EgyptianMau",
        "typeinfo.pets.Manx",
        "typeinfo.pets.Cymric",
        "typeinfo.pets.Rat",
        "typeinfo.pets.Mouse",
        "typeinfo.pets.Hamster"
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