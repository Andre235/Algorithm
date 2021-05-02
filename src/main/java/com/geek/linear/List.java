package com.geek.linear;

import java.util.Iterator;

/**
 * @author: 赵静超
 * @date: 2021/5/2 14:58
 * @description:
 */
public interface List<E> extends Iterable<E> {

    /**
     * 清空线性表
     */
    void clear();

    /**
     * @return 判空
     */
    boolean isEmpty();

    /**
     * @return 获取长度
     */
    int length();

    /**
     * 获取指定索引位置的元素
     * @param index 索引
     * @return 元素
     */
    E get(int index);

    /**
     * 在指定索引处插入元素
     * @param index 索引
     * @param element 元素
     */
    void insert(int index, E element);

    /**
     * 在末尾插入元素
     * @param element 即将插入的元素
     */
    void insert(E element);

    /**
     * 移除指定索引处的元素
     * @param index 索引
     * @return 指定索引处的元素
     */
    E remove(int index);

    /**
     * 查找element元素第一次出现的位置 (不存在则返回 -1)
     * @param element 元素
     * @return 索引
     */
    int indexOf(E element);

    /**
     * 顺序表扩缩容
     * @param newCapacity 新的顺序表容量
     */
    void resize(int newCapacity);
}
