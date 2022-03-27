package com.geek.heap;

import java.util.Comparator;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2022/3/27 14:32
 * @description: 堆排序
 */
public class HeapSort {


    /**
     * 判断堆中索引i处的元素是否小于索引j处的元素
     * @param heap
     * @param i
     * @param j
     * @return
     */
    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    /**
     * 交换heap堆中索引i和索引j处的值
     * @param heap
     * @param i
     * @param j
     */
    private static void exchange(Comparable[] heap, int i, int j) {
        Comparable tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    /**
     * 根据元数据source，构造出heap堆
     * @param source
     * @param heap
     */
    private static void createHeap(Comparable[] source, Comparable[] heap) {
        // 把source中的元素拷贝到heap数组中，此时heap是一个无序的堆
        System.arraycopy(source, 0, heap, 1, source.length);

        // 对堆中的元素做下沉调整（从堆长度的一半处开始，往索引1处扫描）
        for (int i = heap.length / 2; i > 0; i--) {
            sink(heap, i, heap.length - 1);
        }
    }

    /**
     * 对source数组中的数据从小大小尽心排序
     */
    public static void sort(Comparable[] source) {
        // 1.构建堆e
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);
        // 2.定义一个变量，记录未排序的元素中的最大索引
        int num = heap.length - 1;
        // 3.通过循环，交换索引1处的元素和需要排序的元素列表中的最大索引处的元素
        while (num != 1) {
            // 交换元素
            exchange(heap, 1, num);
            // 4.排序交换后最大元素的索引，让它不要参
            // 5. 对索引1处的元素进行堆的下沉调整与对的下沉调整
            num --;
            sink(heap, 1, num);
        }
        // 把heap中的数据复制到原数组source中
        System.arraycopy(heap, 1, source, 0, source.length);
    }

    /**
     * 在heap堆中，对target处的元素做下沉，范围是 0~range
     * @param heap
     * @param target
     * @param range
     */
    private static void sink(Comparable[] heap, int target, int range) {
        // 通过循环不断比较当前k节点和其左子节点2*k 以及右子节点2*k+1处的较大值的元素的大小，如果过当前节点小，则交换其位置
        while (2*target <= range) {
            // 1.找出当前节点的最大的子节点
            // 最大子节点索引
            int tempMaxIndex = 0;
            if (2*target + 1 <= range) { // 如果target索引处的节点存在右子节点
                tempMaxIndex = less(heap, 2*target, 2*target + 1) ? 2*target + 1 : 2*target;
            } else {
                tempMaxIndex = 2*target; // 如果target索引处的节点不存在右子节点，则直接将左子节点的索引赋值给tempMaxIndex
            }

            // 2.比较当前节点的值和最大子节点的值
            if(!less(heap, target, tempMaxIndex)) {
                break;
            }
            exchange(heap, target, tempMaxIndex);
            target = tempMaxIndex;
        }
    }
}
