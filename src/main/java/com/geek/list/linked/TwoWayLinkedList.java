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
            // 创建新节点
            Node<E> newNode = new Node<>(element, this.head, null);
            // 让新节点称为尾结点
            this.last = newNode;
            // 让新节点指向尾结点
            this.head.next = newNode;
        } else { // 如果链表不为空
            // 创建临时尾结点
            Node<E> oldNode = last;
            // 创建新节点
            Node<E> newNode = new Node<>(element, oldNode, null);
            // 当前的尾结点指向新创建的节点
            oldNode.next = newNode;
            // 让新节点成为尾结点
            this.last = newNode;
        }
        this.length ++;
    }

    @Override
    public E remove(int index) {
        // 判断列表是否为空，为空则直接返回null
        if(isEmpty() || index > length - 1) {
            return null;
        }
        // 找到index位置处的前一个节点
        Node<E> pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        // 要删除索引位置处的节点是否为last节点
        E result = null;
        if(length -1  == index) { // 要删除索引位置上的元素为链表的最后一个元素
            pre.next = null;
            last = pre;
            result = pre.data;
        }else { // 要删除索引位置上的元素不是链表的最后一个元素
            // 找到index位置处的节点
            Node<E> currentNode = pre.next;
            // 找到index位置处的下一个节点
            Node<E> nextNode = currentNode.next;
            // 让index位置处的上一个节点的后继节点 指向index位置处的下一个节点
            pre.next = nextNode;
            // 让index位置处的下一个节点的前驱节点 指向index位置处的上一个节点
            nextNode.pre = pre;
            result = currentNode.data;
        }
        length --;
        return result;
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
    public Node<E> reverse(Node<E> currentNode) {
        if (currentNode.next == null) {
            head.next = currentNode;
            return currentNode;
        }
        // 递归反转当前节点的下一个节点，返回值就是链表反转后当前节点的上一个节点
        Node<E> preNode = reverse(currentNode.next);
        // 让返回的节点的下一个节点变为当前节点
        preNode.next = currentNode;
        currentNode.next = null;
        return currentNode;
    }

    @Override
    public Iterator<E> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator<E> {
        private Node<E> node;

        public TIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public E next() {
            node = node.next;
            return node.data;
        }
    }

    /**
     * 内部类
     * @param <E> 存储数据数据类型
     */
    @ToString
    private static class Node<E> {
        /**
         * 前驱指针域
         */
        private Node<E> pre;
        /**
         * 数据域
         */
        private E data;
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
