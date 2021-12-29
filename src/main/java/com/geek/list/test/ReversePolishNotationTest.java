package com.geek.list.test;

import com.geek.list.linked.Stack;

/**
 * @author: lucas.zhao@kuhantech.com
 * @date: 2021/12/29 11:01
 * @description: 根据逆波兰表达式求结果
 */
public class ReversePolishNotationTest {

    public static void main(String[] args) {
        //中缀表达式3*（17-15）+18/6的逆波兰表达式如下
        String string = "3*（17-15）+18/6";
        String[] notation = {"3", "17", "15", "-", "*","18", "6","/","+"};

        Double result = calculate(notation);
        System.out.println(string + "计算的结果为: " + result);
    }

    private static Double calculate(String[] notations) {
        // 1.定义一个操作数，用来存储操作数
        Stack<Double> myStack = new Stack<>();
        double tempResult = 0.0;
        double num1 = 0.0;
        double num2 = 0.0;

        // 2.从左至右遍历逆波兰表达式，得到每一个元素
        for (int i = 0; i < notations.length; i++) {
            String notation = notations[i];
            // 3.判断当前元素时操作数还是操作符
            switch (notation) {
                case "+" : // 4.如果是操作符号，则从栈中弹出两个元素计算结果后，再压栈
                    num1 = myStack.pop();
                    num2 = myStack.pop();
                    tempResult = num2 + num1;
                    myStack.push(tempResult);
                    break;
                case "-" :
                    num1 = myStack.pop();
                    num2 = myStack.pop();
                    tempResult = num2 - num1;
                    myStack.push(tempResult);
                    break;
                case "*" :
                    num1 = myStack.pop();
                    num2 = myStack.pop();
                    tempResult = num2 * num1;
                    myStack.push(tempResult);
                    break;
                case "/" :
                    num1 = myStack.pop();
                    num2 = myStack.pop();
                    tempResult = num2 / num1;
                    myStack.push(tempResult);
                    break;
                default: // 5.如果是操作数，则直接压栈
                    Double value = new Double(notation);
                    myStack.push(value);
                    break;
            }
        }
        // 6.循环完毕后，栈中最后一个元素就是计算结果
        long length = myStack.length();
        System.out.println("此时栈中元素个数为：" + length);
        if (length == 1) {
            return myStack.pop();
        } else {
            return null;
        }
    }
}
