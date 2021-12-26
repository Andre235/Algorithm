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
        linkedList.reverse();
        for (String node : linkedList) {
            System.out.println(node);
        }
    }
}
