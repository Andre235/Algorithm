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
        this.items = (T[]) new Comparable[capacity + 1];
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
        items[++count] = t;
        swim(count);
    }

    /**
     * 使用上浮算法，使索引k处的元素能在堆中处于正确的位置
     * @param k 节点所在的索引
     */
    public void swim(int k) {
        // 通过循环，不断比较当前节点的值和其父节点的值的大小，如果当前节点的值 > 父节点的值，则交换两个元素位置
        // 数组是从下标1位置开始存储元素的
        while (k > 1) {
            if (less(k / 2, k)) {
                exchange(k / 2, k);
            }
            k = k / 2;
        }
    }

    /**
     * 删除堆中最大的元素，并返回这个元素
     * @return
     */
    public T deleteMax() {
        T max = items[1];
        // 交换索引1处的元素和最大索引处的元素，让完全二叉树的最下层最右侧的元素(即刚才索引最大处的元素)称为临时根节点
        exchange(1, count);
        // 删除当前最大索引处的元素，置为null即可
        items[count] = null;
        // 元素个数 -1
        count --;
        // 通过下沉算法调整当前临时根节点的位置，使堆重新有序
        sink(1);
        return max;
    }

    /**
     * 使用下沉算法，使索引k处的元素能在堆中处于正确的位置
     * @param k
     */
    public void sink(int k) {
        // 通过循环不断比较当前k节点和其左子节点2*k 以及右子节点2*k+1处的较大值的元素的大小，如果过当前节点小，则交换其位置
        while (2*k <= count) {
            // 获取当前节点的子节点的较大节点
            // 记录较大子节点所在的索引
            int tempMaxIndex = 0;
            // 如果当前节点存在右子节点，则进行比较
            if (2*k + 1 <= count) {
                tempMaxIndex = less(2*k + 1, 2*k) ? 2*k : 2*k + 1;
            } else {
                tempMaxIndex = 2*k;
            }

            // 比较当前节点和较大子节点的值
            if(less(tempMaxIndex, k)) {
                break;
            }
            exchange(k, tempMaxIndex);
            k = tempMaxIndex;
        }
    }
}


