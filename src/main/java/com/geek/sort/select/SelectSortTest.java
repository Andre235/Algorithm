package com.geek.sort.select;

import com.geek.sort.Student;

/**
 * @author: 赵静超
 * @date: 2021/5/2 11:33
 * @description:
 */
@SuppressWarnings("all")
public class SelectSortTest {

    public static void main(String[] args) {
        Student[] students = {
                new Student("andre", 19),
                new Student("lucas", 21),
                new Student("natasha", 10),
                new Student("zhaosi", 12),
        };

        SelectSort.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
