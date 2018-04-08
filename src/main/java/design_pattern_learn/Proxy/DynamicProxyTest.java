package design_pattern_learn.Proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    /**
     * @author 五月的仓颉http://www.cnblogs.com/xrq730/p/7003082.html
     */
    public static void main(String[] args) {

        Dao daoDecorated = new LogDao(new DaoImpl());
        daoDecorated.delete();
        daoDecorated.insert();
        daoDecorated.update();

        System.out.println("-----------------------------------------");

        Dao dao = new DaoImpl();

        Dao proxyDao = (Dao)Proxy.newProxyInstance(LogInvocationHandler.class.getClassLoader(),
                new Class<?>[]{Dao.class}, new LogInvocationHandler(dao));

        proxyDao.insert();
        System.out.println("----------分割线----------");
        proxyDao.delete();
        System.out.println("----------分割线----------");
        proxyDao.update();
    }
}
