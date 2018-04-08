package com.wagic.code.learn;

import java.util.Stack;

/**
 * 问题描述：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead,
 */
public class ConstructStackAsQueue {

    private Stack<String> stackOne = new Stack<>();

    private Stack<String> stackTwo = new Stack<>();

    public void appendTail(String s) {
        stackOne.push(s);
    }

    public String deleteHead() {
        if (stackTwo.isEmpty()) {
            if (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
        }

        if (stackTwo.isEmpty()) {
            System.out.println("队列为空，无法删除");
        }

        return stackTwo.pop();
    }

    public static void main(String[] args) {
        ConstructStackAsQueue constructStackAsQueue = new ConstructStackAsQueue();
        // 向空的队列中添加元素、删除元素
        constructStackAsQueue.appendTail("1");
        System.out.println(constructStackAsQueue.deleteHead());
        // 向非空的队列添加删除元素
        constructStackAsQueue.appendTail("2");
        constructStackAsQueue.appendTail("3");
        System.out.println(constructStackAsQueue.deleteHead());
    }
}
