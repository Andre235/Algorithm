package com.geek.list.test;

import com.geek.list.linked.Stack;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2021/12/28 20:01
 * @description:
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        for (String data : stack) {
            System.out.println(data);
        }
        System.out.println("------------------------");
        System.out.println("出栈：" + stack.pop());
        for (String data : stack) {
            System.out.println(data);
        }
    }
}
