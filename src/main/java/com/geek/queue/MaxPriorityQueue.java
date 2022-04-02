package com.geek.queue;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2022/3/27 19:39
 * @description:
 */
public class MaxPriorityQueue<T extends Comparable<T>> {
    /**
     * 存储堆中的元素
     */
    private T[] items;
    /**
     * 记录堆中元素的个数
     */
    private int N;

    public MaxPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.N= 0;
    }

    /**
     * 获取队列中元素的个数
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return N==0;
    }

    /**
     * 判断堆中索引i处的元素是否小于索引j处的元素
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j])<0;
    }

    /**
     * 交换堆中i索引和j索引处的值
     * @param i
     * @param j
     */
    private void exchange(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    /**
     * 往堆中插入一个元素
     * @param t
     */
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    /**
     * 删除堆中最大的元素,并返回这个最大元素
     * @return
     */
    public T delMax() {
        T max = items[1];
        // 交换1位置处的元素和最大索引处的元素的值
        exchange(1, N);
        items[N] = null;
        N--;

        // 此时刚才交换之前的最大索引处的元素在根节点，破坏了树的有序性，
        // 需要通过下沉算法，使树重新有序
        sink(1);
        return max;
    }

    /**
     * 上浮算法思想：使索引k处的元素能在堆中处于一个正确的位置
     * 上浮算法基本实现；通过循环比较当前元素和父元素的大小，如果当前元素比父元素大，则该数据往上走
     * @param k
     */
    private void swim(int k) {
        //
        //
        while (k > 1) { // k = 1临界值问题考虑：如果K = 1时即为根节点，不需要再进行上浮，k = 1时不需要再进行循环
            if (less(k/2, k)) {
                exchange(k/2, k);
            }
            k = k / 2;
        }
    }

    /**
     * 下沉算法思想：使索引k处的元素能在堆中处于一个正确的位置
     * 下沉算法基本实现：当前节点和其两个子节点中较大的一个节点比较，如果较大的子节点 > 当前节点，则互换两节节点位置
     * @param k
     */
    private void sink(int k) {
        while (2*k <= N) {
            int tempMaxIndex;
            if (2*k + 1 <= N) { // 证明有右子节点，接下来在左子节点、右子节点中寻找最大的那个索引
                tempMaxIndex = less(2*k, 2*k + 1) ? 2*k + 1 : 2*k;
            } else { // 没有右子节点
                tempMaxIndex = 2*k; // 将左子节点索引赋值给tempMaxIndex
            }

            // 当前k索引处的元素已经大于他的子节点元素，则直接退出循环
            if(!less(k, tempMaxIndex)) {
                break;
            }

            // 否则继续下沉
            exchange(k, tempMaxIndex);
            k = tempMaxIndex;
        }
    }
}
