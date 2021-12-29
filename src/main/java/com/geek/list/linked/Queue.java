package com.geek.list.linked;

import lombok.Data;

import java.util.Iterator;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2021/12/29 13:55
 * @description: 队列实现
 */
public class Queue<T> implements Iterable<T>{

    /**
     * 头结点不存储数据
     */
    private Node<T> head;
    /**
     * 尾结点，存储数据
     */
    private Node<T> last;
    private long length;

    public long getLength() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public Queue (){
        this.head = new Node<>(null, null);
        this.last = null;
        this.length = 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data, null);
        if (this.last == null) {
            this.last = newNode;
            this.head.next = this.last;
        } else {
            Node<T> oldLast = this.last;
            this.last = newNode;
            oldLast.next = this.last;
        }
        this.length ++;
    }

    public T dequeue() {
        T data;
        if (isEmpty()) {
            data = null;
        } else if (this.length == 1) {
            Node<T> oldFirst = this.head.next;
            this.head.next = null;
            this.last = null;
            data = oldFirst.data;
        } else {
            Node<T> oldFirst = this.head.next;
            this.head.next = oldFirst.next;
            oldFirst.next = null;
            data = oldFirst.data;
        }
        this.length --;
        return data;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator<T>{
        private Node<T> n = head;
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }
        @Override
        public T next() {
            Node<T> node = n.next;
            n = n.next;
            return node.data;
        }
    }

    @Data
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
}
