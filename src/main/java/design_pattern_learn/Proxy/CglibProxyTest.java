package design_pattern_learn.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyTest {
    public void test(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibProxyTest.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method,
                                    Object[] args1, MethodProxy proxy) throws Throwable {
                System.out.println("before method run...");
                Object result = proxy.invokeSuper(obj, args1);
                System.out.println("after method run...");
                return result;
            }
        });
        CglibProxyTest sample = (CglibProxyTest) enhancer.create();
        sample.test();
    }
}
