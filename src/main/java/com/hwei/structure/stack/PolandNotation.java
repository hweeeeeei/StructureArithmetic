package com.hwei.structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰计算器
 * 后缀表达式: 运算符在数字的后面
 */
public class PolandNotation {
    public static void main(String[] args) {
        //  (3+4)×5-6 对应的后缀表达式就是 3 4 + 5 × 6 -
        String suffixExpress = "3 4 + 5 * 6 -";

        List<String> listString = getListString(suffixExpress);
        int cal = cal(listString);
        System.out.println("res:" + cal);

    }

    /**
     * 表达式放入数组
     *
     * @param suffixExpression
     * @return
     */
    public static List<String> getListString(String suffixExpression) {

        // 根据空格切割放入列表
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    /**
     * 完成逆波兰表达式的运算
     */
    public static int cal(List<String> suffixList) {

        // 定义一个栈
        Stack<String> stack = new Stack<>();

        // 遍历list
        for (String item : suffixList) {
            // 判断是否为数字
            if (item.matches("\\d+")) {
                // 数字直接入栈
                stack.push(item);
            } else {

                // 否则为符号, 符号需要进行运算
                // 从数栈中弹出两个值进行运算

                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;

                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("符号错误");
                }
                // 将运算后的值压入数栈
                stack.push(String.valueOf(res));

            }
        }


        // 返回运算结果
        return Integer.parseInt(stack.pop());
    }

}
