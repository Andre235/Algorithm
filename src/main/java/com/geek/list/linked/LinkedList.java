package com.geek.list.linked;

import com.geek.list.List;
import lombok.ToString;

import java.util.Iterator;

/**
 * @author: 赵静超
 * @date: 2021/5/2 17:55
 * @description:
 */
@ToString
public class LinkedList<T> implements List<T> {

    private Node<T> head;

    private int length;


    public LinkedList() {
        this.head = new Node<T>(null, null);
        this.length = 0;
    }

    @Override
    public void clear() {
        this.head.next = null;
        this.length = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public T get(int index) {
        // 通过循环从头结点依次往后找，循环index次
        Node<T> node = this.head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    @Override
    public void insert(int index, T element) {
        // 找到index索引处的前一个节点
        Node<T> preNode = this.head.next;
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.next;
        }
//        // 创建一个新的节点
//        Node<T> newNode = new Node<>(element, null);
//        // 前一个节点指向新创建的节点
//        preNode.next = newNode;
//        // 新创建的节点的后继节点直线原来节点的后继节点
//        Node<T> currentNode = preNode.next;
//        Node<T> nextNode = currentNode.next;
//        if(nextNode == null) {
//            currentNode.next = newNode;
//        }else {
//            nextNode.next = newNode;
//        }
        Node<T> currentNode = preNode.next;
        Node<T> newNode = new Node<>(element, currentNode);
        preNode.next = newNode;
        this.length ++;
    }

    @Override
    public void insert(T element) {
        // 找出当前链表中的最后一个节点
        Node<T> node = this.head;

        // TODO 测试这个判断是否多余？
//        if(node.data == null) {
//            node.data = element;
//            // 链表长度加一
//            this.length ++;
//            return;
//        }
        while (node.next != null) {
            node = node.next;
        }
        // 创建一个新的节点
        Node<T> newNode = new Node<>(element, null);
        // 将最后一个节点的next指向新创建的节点
        node.next = newNode;
        // 链表长度加一
        this.length ++;
    }

    @Override
    public T remove(int index) {
        // 找到index索引处的前一个节点
        Node<T> preNode = this.head;
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.next;
        }
        Node<T> currentNode = preNode.next;
        preNode.next = currentNode.next;
        this.length --;
        return currentNode.data;
    }

    @Override
    public int indexOf(T element) {
        Node<T> node = this.head.next;
        int index = 0;
        while (node.next != null) {
            if(element.equals(node.data)){
                return index;
            }
            node = node.next;
            index ++;
        }
        return -1;
    }

    @Override
    public void resize(int newCapacity) {

    }

    /**
     * 对整个链表进行反转
     */
    public void reverse() {
        if (isEmpty() || length == 1) {
            return;
        }
        reverse(head.next);
    }

    /**
     * 反转指定节点 currentNode，并且把反转后的节点返回
     * @param currentNode
     * @return
     */
    public Node<T> reverse(Node<T> currentNode) {
        if (currentNode.next == null) {
            head.next = currentNode;
            return currentNode;
        }
        // 递归反转当前节点的下一个节点，返回值就是链表反转后当前节点的上一个节点
        Node<T> preNode = reverse(currentNode.next);
        // 让返回的节点的下一个节点变为当前节点
        preNode.next = currentNode;
        currentNode.next = null;
        return currentNode;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }


    /**
     * 内部类
     * @param <T> 存储数据数据类型
     */
    @ToString
    private static class Node<T> {
        /**
         * 数据域
         */
        private T data;
        /**
         * 指针域
         */
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private class LIterator implements Iterator<T> {
        private Node<T> node;

        public LIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public T next() {
            node = node.next;
            return node.data;
        }
    }
}
