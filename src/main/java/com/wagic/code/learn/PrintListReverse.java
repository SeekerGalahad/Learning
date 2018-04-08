package com.wagic.code.learn;

import java.util.Stack;

class LinkNode {
    LinkNode next;
    int node_value;
}

public class PrintListReverse {

    public void reverse(LinkNode headNode) {

        Stack<LinkNode> stack = new Stack<>();

        while (headNode != null) {
            stack.push(headNode);
            headNode = headNode.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().node_value);
        }

    }

    public static void main(String args[]) {
        LinkNode node_one = new LinkNode();
        LinkNode node_two = new LinkNode();
        LinkNode node_three = new LinkNode();
        node_one.node_value = 1;
        node_two.node_value = 2;
        node_three.node_value = 3;
        node_one.next = node_two;
        node_two.next = node_three;
        PrintListReverse printListReverse = new PrintListReverse();
        printListReverse.reverse(node_one);
    }
}
