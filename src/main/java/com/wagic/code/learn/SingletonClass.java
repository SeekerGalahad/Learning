package com.wagic.code.learn;

/**
 * 题目描述：设计一个类，我们只能生成一个实例
 */
public class SingletonClass {

    // volatile 防止指令重排序
    private static volatile SingletonClass instance;


    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        // 双重判断，第一层判断避免对象不为空时每次都进入同步代码块
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }

        return instance;
    }


}
