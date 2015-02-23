package generics;

import java.util.*;
import java.lang.reflect.*;

/**
 * RUN:
 *         javac generics/MultipleInterfaceVariants.java
 * OUTPUT:
 *         
 */

// CompileTimeError
// 
public class MultipleInterfaceVariants {

}

interface Payable<T> {}

class Employee implements Payable<Employee> {}

// 
// error: Payable cannot be inherited with different arguments: <generics.Hourly> and <generics.Employee>
// 
class Hourly extends Employee implements Payable<Hourly> {}