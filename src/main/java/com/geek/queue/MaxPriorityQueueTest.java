package com.geek.queue;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2022/4/2 10:25
 * @description:
 */
public class MaxPriorityQueueTest {
    public static void main(String[] args) {
        MaxPriorityQueue<String> maxPriorityQueue = new MaxPriorityQueue<>(10);

        maxPriorityQueue.insert("A");
        maxPriorityQueue.insert("B");
        maxPriorityQueue.insert("C");
        maxPriorityQueue.insert("D");
        maxPriorityQueue.insert("E");
        maxPriorityQueue.insert("F");

        while (!maxPriorityQueue.isEmpty()) {
            System.out.print(maxPriorityQueue.delMax() + " ");
        }
    }
}
