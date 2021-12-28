package com.geek.list.test;


import com.geek.list.linked.Stack;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2021/12/28 21:16
 * @description:
 */
public class BracketsMatchTest {

    private final static String LEFT_BRACKETS = "(";
    private final static String RIGHT_BRACKETS = ")";

    public static void main(String[] args) {
        String str = ")(";
        boolean isMatch = isMatch(str);
        System.out.println(str + "括号是否匹配：" + isMatch);
    }

    public static boolean isMatch(String string) {
        // 1.创建栈对象，用来存储左括号
        Stack<String> myStack = new Stack<>();
        if (string.length() == 0) {
            return false;
        }
        // 2.从左往右遍历字符串
        for (int i = 0; i < string.length(); i++) {
            String currentChar = string.charAt(i) + "";
            // 3.判断当前字符串是否为左括号， 如果是则入栈
            if (currentChar.equals(LEFT_BRACKETS)) {
                myStack.push(currentChar);
            } else if (currentChar.equals(RIGHT_BRACKETS)){
                // 4.判断当前字符串是否为右括号，如果是则从当前栈中弹出一个左括号，并判断是否为null，如果为null则说明括号不匹配，返回false
                String data = myStack.pop();
                if (data == null) {
                    return false;
                }
            }
        }
        // 5.循环结束后，判断栈中是否还有剩余的左括号，如果有则说明括号不匹配，返回false
        return myStack.isEmpty();
    }
}
