package design_pattern_learn.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 五月的仓颉http://www.cnblogs.com/xrq730/p/7003082.html
 */
public class LogInvocationHandler implements InvocationHandler {

    private Object obj;

    public LogInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if ("insert".equals(methodName) || "update".equals(methodName)) {
            System.out.println(methodName + "()方法开始时间：" + System.currentTimeMillis());
            Object result = method.invoke(obj, args);
            System.out.println(methodName + "()方法结束时间：" + System.currentTimeMillis());

            return result;
        }

        return method.invoke(obj, args);
    }

}