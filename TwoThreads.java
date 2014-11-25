public class TwoThreads {
    
    private static Object resource = new Object();

    private static void delay(long n) {
        try {
            Thread.sleep(n);
        }
        catch(Exception e) {
            System.out.println("Error:"+e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("StartMain");

        new Thread1().start();
        delay(1000);
        
        Thread2 t2 = new Thread2();
        t2.start();
        delay(1000);
        t2.interrupt();
        delay(1000);

        System.out.println("EndMain");
    }

    static class Thread1 extends Thread {
        public void run() {
            synchronized(resource) {
                System.out.println("Start 1");
                delay(6000);
                System.out.println("End 1");
            }
        }
    }

    static class Thread2 extends Thread {
        public void run() {
            synchronized(resource) {
                System.out.println("Start 2");
                delay(2000);
                System.out.println("End 2");
            }
        }
    }

}