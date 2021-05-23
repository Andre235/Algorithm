package com.geek.list.linked;

import com.geek.list.List;
import lombok.ToString;

import java.util.Iterator;

/**
 * @author: 赵静超
 * @date: 2021/5/2 19:26
 * @description: 头结点不存储数据
 */
public class TwoWayLinkedList<E> implements List<E> {

    private Node<E> head;

    private Node<E> last;

    private int length;


    public TwoWayLinkedList() {
        this.head = new Node<E>(null, null, null);
        this.last = null;
        this.length = 0;
    }

    @Override
    public void clear() {
        this.head.next = null;
        this.last = null;
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

    public E getFirst() {
        if(this.isEmpty()) {
            return null;
        }
        return this.head.next.data;
    }

    public E getLast() {
        if(this.isEmpty()) {
            return null;
        }
        return this.last.data;
    }

    @Override
    public E get(int index) {
        if(isEmpty()) {
            return null;
        }
        Node<E> node = this.head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    @Override
    public void insert(int index, E element) {
        // 找到i - 1 位置上的节点
        Node<E> pre = this.head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        // 找到i位置上的节点
        Node<E> currentNode = pre.next;
        // 创建新节点
        Node<E> newNode = new Node<>(element, null, null);
        // 让新节点称为i - 1 位置节点的后继节点
        pre.next = newNode;
        newNode.pre = pre;
        // 让新节点成为i 位置节点的前驱节点
        newNode.next = currentNode;
        currentNode.pre = newNode;
        // 元素个数 ++
        this.length ++;
    }

    @Override
    public void insert(E element) {
        // 如果链表为空
        if(this.isEmpty()) {
            Node<E> newNode = new Node<>(element, this.head, null);
            this.last = newNode;
            this.head.next = newNode;
        } else { // 如果链表不为空
            // 创建新节点
            Node<E> newNode = new Node<>(element, this.last, null);
            // 当前的尾结点指向新创建的节点
            this.last.next= newNode;
            // 让新节点成为尾结点
            this.last = newNode;
        }
        this.length ++;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = this.head;
        for (int i = 0; node.next != null; i++) {
            node = node.next;
            if(node.data.equals(element)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void resize(int newCapacity) {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * 内部类
     * @param <E> 存储数据数据类型
     */
    @ToString
    private static class Node<E> {
        /**
         * 数据域
         */
        private E data;
        /**
         * 前驱指针域
         */
        private Node<E> pre;
        /**
         * 后继指针域
         */
        private Node<E> next;

        public Node(E data, Node<E> pre, Node<E> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }
}
