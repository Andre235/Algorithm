package com.geek.sort;

import java.util.Comparator;

/**
 * @author: 赵静超
 * @date: 2021/5/2 9:58
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        Student stu1 = new Student("张三", 51);
        Student stu2 = new Student("李四", 20);
        Comparable<Student> maxAge = getMaxAge(stu1, stu2);
        System.out.println(maxAge);
    }

    private static Comparable<Student> getMaxAge(Comparable<Student> comparable1, Comparable<Student> comparable2) {
        return comparable1.compareTo((Student) comparable2) >= 0 ? comparable1 : comparable2;
    }
}



