package com.geek.sort.bubble;

import com.geek.sort.Student;

/**
 * @author: 赵静超
 * @date: 2021/5/2 11:13
 * @description:
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        Student[] students = {
          new Student("andre", 19),
          new Student("lucas", 21),
          new Student("natasha", 10),
          new Student("zhaosi", 12),
        };

        BubbleSort.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
