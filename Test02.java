
public class Test02 {

    public static void main(String[] args) {
        //
        parse("invalid");
    }

    public static void parse(String str) {
        try {
            float f = Float.parseFloat(str);
        }
        catch (NumberFormatException e) {
            f = 0;
        }
        finally {
            System.out.println(f);
        }
    }

}