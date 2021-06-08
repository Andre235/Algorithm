package com.geek.list.linked;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2021/6/8 20:44
 * @description:
 */
public class TwoWayLinkedListTest {

    public static void main(String[] args) {
        TwoWayLinkedList<String> linkedList = new TwoWayLinkedList<>();
        linkedList.insert("姚明");
        linkedList.insert("科比");
        linkedList.insert("麦迪");
        linkedList.insert(1, "詹姆斯");

        for (String node : linkedList) {
            System.out.println(node);
        }

        System.out.println("-----------------------------------");
        System.out.println("双向链表第一个元素：" + linkedList.getFirst());
        System.out.println("双向链表最后一个元素：" + linkedList.getLast());


        System.out.println("-----------------------------------");
//        // 测试获取
//        String node1 = linkedList.get(1);
//        System.out.println(node1);
//        // 测试删除
//        String removeResult = linkedList.remove(0);
//        System.out.println(removeResult);
//        // 测试清空
//        linkedList.clear();
//        System.out.println("清空之后的线性表元素个数为：" + linkedList.length());

        System.out.println(linkedList.remove(3));
//        System.out.println(linkedList.remove(3));
    }
}
