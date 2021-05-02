package com.geek.sort;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 赵静超
 * @date: 2021/5/2 9:57
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student>{

    private String username;

    private Integer age;

    @Override
    public int compareTo(Student student) {
        return this.age - student.age;
    }
}

