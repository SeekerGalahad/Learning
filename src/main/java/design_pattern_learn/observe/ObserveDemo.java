package design_pattern_learn.observe;

import java.util.Observable;

public class ObserveDemo {

    public static void main(String[] args) {

        MyObserver myObserver = new MyObserver();

        myObserver.addObserver((o, arg) -> System.out.println("张三， 订阅邮件1"));
        myObserver.addObserver((o, arg) -> System.out.println("李四， 订阅邮件2"));
        myObserver.addObserver((o, arg) -> System.out.println("王五， 订阅邮件3"));

        myObserver.setChange();

        myObserver.notifyObservers();

    }

    static class MyObserver extends Observable {

        public void setChange() {
            super.setChanged();
        }
    }
}
