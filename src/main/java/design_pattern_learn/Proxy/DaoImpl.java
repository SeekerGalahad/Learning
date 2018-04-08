package design_pattern_learn.Proxy;
/**
 * @author 五月的仓颉http://www.cnblogs.com/xrq730/p/7003082.html
 */
public class DaoImpl implements Dao {

    @Override
    public void insert() {
        System.out.println("DaoImpl.insert()");
    }

    @Override
    public void delete() {
        System.out.println("DaoImpl.delete()");
    }

    @Override
    public void update() {
        System.out.println("DaoImpl.update()");
    }

}
