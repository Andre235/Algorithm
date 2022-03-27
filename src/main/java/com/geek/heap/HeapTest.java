package com.geek.heap;/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2022/3/27 14:13
 * @description: 
 */
public class HeapTest {
    public static void main(String[] args) {
        // 创建堆对象
        Heap<String> heap = new Heap<>(10);

        //往堆中存入字符串数据
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");

        //通过循环从堆中删除数据
        String result;
        while((result = heap.deleteMax()) != null){
            System.out.print(result+" ");
        }
        System.out.println();
    }
}
