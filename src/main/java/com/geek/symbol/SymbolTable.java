package com.geek.symbol;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2021/12/29 17:27
 * @description: 符号表基本API实现
 */
public class SymbolTable<K, V> {

    private Node<K, V> head;

    private int length;

    public SymbolTable() {
        this.head = new Node<>(null, null, null);
        this.length = 0;
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty () {
        return this.length == 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("The key value cannot be null.");
        }
        // 1.如果符号表中已经存在了键为K的键值对，则找到并替换
        Node<K, V> node = this.head;
        while (node.next != null) {
            node = node.next;
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        // 2.不存在则创建新的节点，头插法，链表长度加一
        Node<K, V> newNode = new Node<>(key, value, null);
        Node<K, V> oldFirstNode = head.next;
        this.head.next = newNode;
        newNode.next = oldFirstNode;
        this.length ++;
    }

    public V get(K key) {
        Node<K, V> tempNode = this.head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            if (tempNode.key.equals(key)) {
                return tempNode.value;
            }
        }
        return null;
    }

    public void delete(K key) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("The current symbol table is empty, cannot be deleted");
        }
        Node<K, V> node = this.head;
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                node.next = node.next.next;
                this.length --;
                return;
            }
            node = node.next;
        }
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
