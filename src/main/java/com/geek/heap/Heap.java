package com.geek.heap;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2022/3/26 20:22
 * @description:
 */
public class Heap<T extends Comparable<T>> {

    /**
     * 存储堆中的元素
     */
    private T[] items;
    /**
     * 记录堆中元素的个数
     */
    private int count;

    public Heap(int capacity) {
        this.items = (T[]) new Object[capacity];
        this.count = 0;
    }

    /**
     * 判断堆中索引i处的元素是否小于索引j处的元素
     * @param i
     * @param j
     * @return
     */
    public boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换堆中i索引和j索引处的值
     * @param i
     * @param j
     */
    public void exchange(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    /**
     * 往堆中插入一个元素
     * @param t
     */
    public void insert(T t) {

    }

    /**
     * 使用上浮算法，使索引k处的元素能在堆中处于正确的位置
     * @param k
     */
    public void swim(int k) {

    }

    /**
     * 使用下沉算法，使索引k处的元素能在堆中处于正确的位置
     * @param k
     */
    public void sink(int k) {

    }

    /**
     * 删除堆中最大的元素，并返回这个元素
     * @return
     */
    public T deleteMax() {
        return null;
    }

}


