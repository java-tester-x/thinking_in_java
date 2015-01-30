package typeinfo;  

import java.util.*;
import java.lang.reflect.*;

import net.mindview.util.*;

/**
 * RUN:
 *         javac typeinfo/NullRobot.java && java typeinfo.NullRobot
 * OUTPUT:
 *         Name: SnowBee
 *         Model: SnowBot Series 11
 *         SnowBee can remove snow
 *         SnowBee remove snow
 *         SnowBee can crush ice
 *         SnowBee crush ice
 *         SnowBee can clean roof
 *         SnowBee clean roof
 *         [Null Robot]
 *         Name: SnowRemovalRobot NullRobot
 *         Model: SnowRemovalRobot NullRobot
 */

public class NullRobot {

    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot)Proxy.newProxyInstance(
            NullRobot.class.getClassLoader()
        ,   new Class[] { Null.class, Robot.class }
        ,   new NullRobotProxyHandler(type)
        );
    }

    public static void main(String[] args) {
        Robot[] bots = {
            new SnowRemovalRobot("SnowBee")
        ,   newNullRobot(SnowRemovalRobot.class)
        };

        for (Robot bot : bots) {
            Robot.Test.test(bot);
        }
    }
}

class NullRobotProxyHandler implements InvocationHandler {

    private String nullName;

    private Robot proxied = new NRobot();

    NullRobotProxyHandler(Class<? extends Robot> type) {
        nullName = type.getSimpleName() + " NullRobot";
    }

    private class NRobot implements Null, Robot {
        public String name() { return nullName; }
        public String model() { return nullName; }
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }
}