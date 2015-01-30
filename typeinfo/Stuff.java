package typeinfo;  

import java.util.*;

/**
 * RUN:
 *         javac typeinfo/Stuff.java && java typeinfo.Stuff
 * OUTPUT:
 *         [Position: President Person: Me Last The Top, Lonely At,
 *          Position: CTO NullPerson, Position: Marketing Manager NullPerson,
 *          Position: Project Lead Person: Janet Planner The Burbs,
 *          Position: Product Manager NullPerson,
 *          Position: Software Engineer Person: Bob Coder Bright Light City,
 *          Position: Software Engineer NullPerson,
 *          Position: Software Engineer NullPerson,
 *          Position: Software Engineer NullPerson,
 *          Position: Test Engineer NullPerson,
 *          Position: Technical Writer NullPerson]
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

    public void fillPosition(String title, Person hire) {
        for (Position position : this) {
            if (position.getTitle().equals(title) &&
                position.getPerson() == Person.NULL)
            {
                position.setPerson(hire);
                return;
            }
        }

        throw new RuntimeException("Position " + title + " not awailable");
    }

    public static void main(String[] args) {
        Stuff staff = new Stuff(
            "President", "CTO", "Marketing Manager", "Project Lead"
        ,   "Product Manager", "Software Engineer"
        ,   "Software Engineer", "Software Engineer"
        ,   "Software Engineer", "Test Engineer"
        ,   "Technical Writer"
        );

        staff.fillPosition("President", new Person("Me", "Last", "The Top, Lonely At"));
        staff.fillPosition("Project Lead", new Person("Janet", "Planner", "The Burbs"));

        if (staff.positionAvailable("Software Engineer")) {
            staff.fillPosition("Software Engineer", new Person("Bob", "Coder", "Bright Light City"));
        }

        System.out.println(staff);
    }
}