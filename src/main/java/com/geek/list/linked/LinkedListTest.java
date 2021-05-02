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
        List<String> list = new LinkedList<>();

        list.insert("姚明");
        list.insert("科比");
        list.insert("麦迪");
        list.insert(1,"汤姆斯");

//        System.out.println(list);
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        list.remove(1);
//        System.out.println(list);


//        for (String s : list) {
//            System.out.println(s);
//        }
    }
}
