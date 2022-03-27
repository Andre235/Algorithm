package com.geek.heap;

import java.util.Arrays;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2022/3/27 18:41
 * @description:
 */
public class HeapSortTest {
    public static void main(String[] args) {
        //待排序数组
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
