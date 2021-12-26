package com.geek.list.linked;

import com.geek.list.List;

import java.util.Iterator;

/**
 * @author: 赵静超
 * @date: 2021/5/2 18:57
 * @description:
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.insert("姚明");
        list.insert("科比");
        list.insert("麦迪");
        list.insert("汤姆斯");

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("-----------------------");

        list.reverse();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
