package exceptions;

/**
 * RUN:
 *         javac exceptions/DynamicFields.java && java exceptions.DynamicFields
 * OUTPUT:
 *         null: null
 *         null: null
 *         null: null
 *         
 *         d: Value of d
 *         number: 47
 *         number2: 48
 *         
 *         df: d: New value of d
 *         number: 47
 *         number2: 48
 *         number3: 11
 *         
 *         df.getField("d")  New value of d
 *         exceptions.DynamicFieldsException
 *                 at exceptions.DynamicFields.setField(DynamicFields.java:101)
 *                 at exceptions.DynamicFields.main(DynamicFields.java:141)
 *         Caused by: java.lang.NullPointerException
 *                 at exceptions.DynamicFields.setField(DynamicFields.java:102)
 *                 ... 1 more
 */

// import java.util.logging.*;
// import java.io.*;


public class DynamicFields {

    private Object[][] fields;

    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[] {null, null};
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] obj : fields) {
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (id.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;
    }

    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if (fieldNum == -1) {
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }

    private int makeField(String id)
    {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }

        //
        Object[][] tmp = new Object[fields.length+1][2];
        for (int i = 0; i < fields.length; i++) {
            tmp[i] = fields[i];
        }
        for (int i = fields.length; i < tmp.length; i++) {
            tmp[i] = new Object[] {null, null};
        }
        fields = tmp;

        return makeField(id);
    }

    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    public Object setField(String id, Object value) throws DynamicFieldsException
    {
        if (value == null) {
            DynamicFieldsException dfe = new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        
        int fieldNumber = hasField(id);
        if (fieldNumber == -1) {
            fieldNumber = makeField(id);
        }

        Object result = null;
        try {
            result = getField(id);
        }
        catch(NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        fields[fieldNumber][1] = value;
        return result;
    }


    public static void main(String[] args)
    {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);

        try {
            df.setField("d", "Value of d");
            df.setField("number", 47);
            df.setField("number2", 48);
            System.out.println(df);

            df.setField("d", "New value of d");
            df.setField("number3", 11);
            System.out.println("df: " + df);

            System.out.println("df.getField(\"d\")  " + df.getField("d"));

            Object field = df.setField("d", null);
        }
        catch(NoSuchFieldException e) {
            e.printStackTrace(System.out);
        }
        catch(DynamicFieldsException e) {
            e.printStackTrace(System.out);
        }
    }
}

class DynamicFieldsException extends Exception {}