package com.geek.list.test;

import lombok.Data;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2021/12/28 14:11
 * @description:
 */
@SuppressWarnings("all")
public class CircleListGetEntranceNodeTest {

    public static void main(String[] args) {
        Node<String> first = new Node<>("1", null);
        Node<String> second = new Node<>("2", null);
        Node<String> third = new Node<>("3", null);
        Node<String> fourth = new Node<>("4", null);
        Node<String> fifth = new Node<>("5", null);
        Node<String> six = new Node<>("6", null);
        Node<String> seven = new Node<>("7", null);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;

        //产生环
        seven.next = third;

        Node<String> entranceNode = getEntranceNode(first);
        if (entranceNode != null) {
            System.out.println("环形链表入口节点为：" + entranceNode.data);
        } else {
            System.out.println("该链表不是唤醒链表");
        }
    }

    private static <T> Node<T> getEntranceNode(Node<T> firstNode) {
        // 定义快慢指针
        Node<T> fastNode = firstNode;
        Node<T> slowNode = firstNode;
        Node<T> tempNode = null;

        // 判断链表是否有环
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

            if (fastNode.equals(slowNode)) {
                tempNode = firstNode;
                continue;
            }
            if (tempNode != null) {
                tempNode = tempNode.next;
                if (tempNode.equals(slowNode)) {
                    return tempNode;
                }
            }
        }
        return tempNode;
    }
    
    @Data
    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
