package design_pattern_learn.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    interface IHello {
        void sayHello();
    }

    static class HellImpl implements IHello {

        @Override
        public void sayHello() {
            System.out.println("Hello world");
        }
    }


    static class MyInvocationHandler implements InvocationHandler {

        private Object obj;

        Object bind(Object obj) {
            this.obj = obj;
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                    new Class<?>[]{IHello.class}, this);
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before........");
            return method.invoke(obj, args);
        }
    }

    public static void main(String[] args) {
        IHello hello = (IHello)new MyInvocationHandler().bind(new HellImpl());
        hello.sayHello();
    }
}
