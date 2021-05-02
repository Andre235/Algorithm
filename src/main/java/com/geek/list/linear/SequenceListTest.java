package com.geek.list.linear;

import com.geek.list.List;

/**
 * @author: 赵静超
 * @date: 2021/5/2 15:36
 * @description:
 */
public class SequenceListTest {
    public static void main(String[] args) {
        List<String> list = new SequenceList<>(10);

        list.insert("姚明");
        list.insert("科比");
        list.insert("麦迪");
        list.insert("汤姆斯");
//        System.out.println(list);
//
//        list.remove(0);
//        System.out.println(list);
//
//        list.remove(0);
//        System.out.println(list);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
