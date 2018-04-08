package com.wagic;

public class SafeBox<V> {

    private V value;

    public synchronized V get() throws InterruptedException {
        while (null == value) wait();

        V result = value;

        value = null;

        notifyAll();

        return result;

    }

    public synchronized void set(V newValue) throws InterruptedException {

        while (null != value) wait();

        value = newValue;

        notifyAll();
    }

}
