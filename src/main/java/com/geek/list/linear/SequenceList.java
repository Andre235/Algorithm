package com.geek.list.linear;

import com.geek.list.List;
import lombok.ToString;

import java.util.Iterator;

/**
 * @author: 赵静超
 * @date: 2021/5/2 14:59
 * @description: 线性表
 */
@ToString
public class SequenceList<E> implements List<E> {

    /**
     * 线性表数组
     */
    private E[] elements;
    /**
     * 元素个数
     */
    private int length;


    public SequenceList(int capacity) {
        this.elements  = (E[]) new Object[capacity];
        this.length = 0;
    }

    @Override
    public void clear() {
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
    public E get(int index) {
        return this.elements[index];
    }

    @Override
    public void insert(int index, E element) {
        if(this.length > this.elements.length) {
            resize(this.elements.length * 2);
        }
        // 把index索引位置以后的所有元素依次向后移动一位即可
        for (int i = this.length; i > index ; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        // 再把element元素放置index索引处
        this.elements[index] = element;
        this.length ++;
    }

    @Override
    public void insert(E element) {
        if(this.length == this.elements.length) {
            resize(this.elements.length * 2);
        }
        this.elements[this.length ++] = element;
    }

    @Override
    public E remove(int index) {
        // 记录要删除索引处的元素
        E element = this.elements[index];

        // 把index索引位置以后的所有元素依次向前移动一位
        for (int i = index; i < this.length; i++) {
            this.elements[i] = this.elements[i + 1];
        }

        // 数组的容量减一
        this.length --;

        if(this.length <= this.elements.length / 4) {
            resize(this.elements.length / 2);
        }
        return element;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < this.length; i++) {
            if(element.equals(this.elements[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void resize(int newCapacity) {
        // 创建一个临时顺序表
        E[] temp = this.elements;
        // 创建一个新的具有合适容量的数组
        this.elements = (E[]) new Object[newCapacity];
        // 把旧数组元素拷贝至新数组当中
        for (int i = 0; i < this.length; i++) {
            this.elements[i] = temp[i];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator<E> {
        private int cursor;

        public SIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return this.cursor > length;
        }

        @Override
        public E next() {
            return elements[cursor ++];
        }
    }
}
