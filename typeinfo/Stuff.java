package typeinfo;  

import java.lang.reflect.*;

/**
 * RUN:
 *         javac typeinfo/Stuff.java && java typeinfo.Stuff
 * OUTPUT:
 *         
 */

public class Stuff extends ArrayList<Position> {

    public void add(String title, Person person) {
        add(new Position(title, person));
    }

    public void add(String... titles) {
        for (String title : titles) {
            add(new Position(title));    
        }
    }

    public Stuff(String... titles) {
        add(titles);
    }

    public boolean positionAvailable(String title) {
        for (Position position : this) {
            if (position.getTitle().equals(title) &&
                position.getPerson() == Person.NULL)
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}