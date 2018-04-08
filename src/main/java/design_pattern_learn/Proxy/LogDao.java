package design_pattern_learn.Proxy;
/**
 * @author 五月的仓颉http://www.cnblogs.com/xrq730/p/7003082.html
 */
public class LogDao implements Dao {

    private Dao dao;

    public LogDao(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void insert() {
        System.out.println("insert()方法开始时间：" + System.currentTimeMillis());
        dao.insert();
        System.out.println("insert()方法结束时间：" + System.currentTimeMillis());
    }

    @Override
    public void delete() {
        dao.delete();
    }

    @Override
    public void update() {
        System.out.println("update()方法开始时间：" + System.currentTimeMillis());
        dao.update();
        System.out.println("update()方法结束时间：" + System.currentTimeMillis());
    }



}
