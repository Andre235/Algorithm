package com.geek.list.linked;

import lombok.Data;
import lombok.ToString;

import java.util.Iterator;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2021/12/28 19:40
 * @description:
 */
@ToString
public class Stack<T>  implements Iterable<T>{

    private Node<T> head;

    private long length;

    public Stack() {
        this.head = new Node<T>(null, null);
        this.length = 0;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public long length() {
        return this.length;
    }

    public void push(T data) {
        Node<T> oldFirstNode = head.next;
        head.next = new Node<>(data, oldFirstNode);
        this.length ++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        Node<T> oldFirstNode = this.head.next;
        this.head.next = oldFirstNode.next;
        this.length --;
        return oldFirstNode.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
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


    /**
     * 内部类
     * @param <T> 存储数据数据类型
     */
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
