package com.geek.select;

import com.geek.sort.Student;

/**
 * @author: 赵静超
 * @date: 2021/5/2 11:33
 * @description:
 * 冒泡排序核心操作
 *   1.每次循环在未排序序列中找出最小元素所在的索引
 *   2.将最小元素所在的索引处的值与未排序序列中的第一个元素进行交换
 */
@SuppressWarnings("all")
public class SelectSort {

    /**
     * 排序
     * @param students
     */
    public static void sort(Comparable<Student>[] students) {
        for (int i = 0; i < students.length - 2; i++) {
            // 定义一个变量，记录最小元素所在位置处的索引(默认为未排序序列中第一个元素的索引)
            int minIndex = i;
            for (int j = i + 1; j < students.length; j++) {
                // 比较最小元素处的索引和j处索引的值
                if(greater(students[minIndex], students[j])) {
                    minIndex = j;
                }
            }
            // 交换元素
            exchange(students, i, minIndex);
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
