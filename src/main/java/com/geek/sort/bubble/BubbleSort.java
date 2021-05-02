package com.geek.sort.bubble;

import com.geek.sort.Student;

import java.util.Comparator;

/**
 * @author: 赵静超
 * @date: 2021/5/2 10:38
 * @description:
 */
public class BubbleSort {
    /**
     * 排序
     * @param students
     */
    public static void sort(Comparable<Student>[] students) {
        // 外层循环：有多少个元素参与冒泡
        for (int i = students.length - 1; i > 0 ; i --) {
            for (int j = 0; j < i; j++) {
                if(greater(students[j], students[j + 1])){
                    exchange(students, j, j+ 1);
                }
            }
        }
    }

    /**
     * 比较大小
     * @param student1
     * @param student2
     * @return 返回较大年龄的学生
     */
    public static boolean greater(Comparable<Student> student1, Comparable<Student> student2) {
        return student1.compareTo((Student) student2) >= 0;
    }

    /**
     * 交换数据
     * @param students
     * @param index1
     * @param index2
     */
    public static void exchange(Comparable<Student>[] students, int index1, int index2) {
        Comparable<Student> temp;
        temp = students[index1];
        students[index1] = students[index2];
        students[index2] = temp;
    }
}
