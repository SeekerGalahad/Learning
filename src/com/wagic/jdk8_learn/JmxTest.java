package com.wagic.jdk8_learn;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

/**
 * @author ChenGang 2005-12-3
 */
class Hello implements HelloMBean {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void printHello() {
        System.out.println("Hello World, " + name);
    }
    public void printHello(String whoName) {
        System.out.println("Hello , " + whoName);
    }
}


/**
 * @author ChenGang 2005-12-3
 */
interface HelloMBean {
    public String getName();
    public void setName(String name);
    public void printHello();
    public void printHello(String whoName);
}


public class HelloAgent {

    public static void main(String[] args) throws Exception {
        MBeanServer server = MBeanServerFactory.createMBeanServer();

        ObjectName helloName = new ObjectName("chengang:name=HelloWorld");
        server.registerMBean(new Hello(), helloName);

        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
        /*HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter, adapterName);

        adapter.start();*/
        System.out.println("start.....");

    }
}

