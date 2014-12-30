package innerclasses;

/**
 * RUN:
 *         javac innerclasses/LocalInnerClass.java && java innerclasses.LocalInnerClass
 * OUTPUT:
 *         LocalCounter()
 *         Counter()
 *         local 0
 *         local 1
 *         local 2
 *         local 3
 *         local 4
 *         anonymous 5
 *         anonymous 6
 *         anonymous 7
 *         anonymous 8
 *         anonymous 9
 */

public class LocalInnerClass {

    private int count = 0;

    Counter getCounter(final String name)
    {
        // local class:
        class LocalCounter implements Counter {
            
            public LocalCounter() {
                System.out.println("LocalCounter()");
            }

            public int next() {
                System.out.print(name+" ");    
                return count++;
            }
        }

        return new LocalCounter();
    }

    Counter getCounter2(final String name)
    {
        // return an object of anonymous class:
        return new Counter() {
            {
                System.out.println("Counter()");
            }

            public int next() {
                System.out.print(name+" ");    
                return count++;    
            }
        };
    }

    public static void main(String[] args)
    {
        LocalInnerClass lic = new LocalInnerClass();
        
        Counter
                c1 = lic.getCounter("local"),
                c2 = lic.getCounter2("anonymous");

        for (int i = 0; i < 5; i++) {
            System.out.println(c1.next());    
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(c2.next());    
        }
    }
}

interface Counter {
    int next();
}