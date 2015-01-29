package typeinfo;  

import java.lang.reflect.*;

/**
 * RUN:
 *         javac typeinfo/SimpleDynamicProxy.java && java typeinfo.SimpleDynamicProxy
 * OUTPUT:
 *         doSomething
 *         somethingElse bonobo
 *         
 *         **** proxy: class typeinfo.$Proxy0, 
 *              method: public abstract void typeinfo.Interface.doSomething(), 
 *              args: null
 *         doSomething
 *          
 *         **** proxy: class typeinfo.$Proxy0, 
 *              method: public abstract void typeinfo.Interface.somethingElse(java.lang.String),
 *              args: [Ljava.lang.Object;@15a3d6b
 *                  bonobo
 *         somethingElse bonobo
 */

public class SimpleDynamicProxy {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        Interface proxy = (Interface)Proxy.newProxyInstance(
            Interface.class.getClassLoader()
        ,   new Class[]{ Interface.class }    
        ,   new DynamicProxyHandler(real)
        );
        consumer(proxy);
    }
}

class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.printf(
              "\n**** proxy: "   + proxy.getClass() 
            + ",\n     method: " + method 
            + ",\n     args: "   + args
            + "\n"
        );

        if (args != null) {
            for (Object arg : args) {
                System.out.printf("%17s\n", arg);
            }
        }

        return method.invoke(proxied, args);
    }
}