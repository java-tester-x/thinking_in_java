package typeinfo;  

import java.lang.reflect.*;

/**
 * RUN:
 *         javac typeinfo/SimpleDynamicProxy.java && java typeinfo.SimpleDynamicProxy
 * OUTPUT:
 *         
 */

public class SimpleDynamicProxy {

}

class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throable {
        System.out.println();
    }
}