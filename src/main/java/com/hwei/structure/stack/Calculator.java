package com.hwei.structure.stack;

/**
 * 栈实现中缀计算器
 */
public class Calculator {
    public static void main(String[] args) {

        String expreession = "3+2*6-2";


        // 创建两个栈 , 数栈,符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        // 扫描下标
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; //  每次扫描

        while (index != expreession.length()) {
            ch = expreession.substring(index, index + 1).charAt(0);
            //判断是数字或符号
            if (operStack.isOper(ch)) {
                System.out.println("isOper:" + ch);

                // 判断符号栈是否为空
                if (operStack.isEmpty()) {
                    // 如果为空, 直接入符号栈
                    operStack.push(ch);
                } else {

                    // 不为空:  判断当前操作符的优先级 小于等于栈中的操作符,
                    // 就需要pop出两个数和符号进行运算,将结果push进数栈,当前符号如符号栈

                    // 判断当前操作符 是否比栈内的操作符优先级小
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {

                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        // 计算结果
                        res = operStack.cal(num1, num2, oper);

                        // 将结果入数栈
                        numStack.push(res);
                        // 将操作符入符号栈
                        operStack.push(ch);
                    } else {

                        // 如果当前操作符优先级大于栈中优先级  直接将操作符入符号栈
                        operStack.push(ch);
                    }

                }

            } else {  // 如果是数字

                numStack.push(ch - 48);
                System.out.println("not isOper:" + ch);
            }

            index++;

        }


        // 当表达式扫描完毕后就顺序的从符号栈和数栈冲pop出 进行运算
        while (true) {

            // 如果符号栈为空 ,则计算到最后的结果
            if (operStack.isEmpty()) {
                break;
            }

            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            // 计算结果
            res = operStack.cal(num1, num2, oper);

            // 将结果入数栈
            numStack.push(res);
        }

        //  最后留在数栈中的值 就是结果
        int lastRes = numStack.pop();
        System.out.printf("lastRes :" + lastRes);
    }
}

// 创建一个栈

/**
 * 定义一个类 表示栈
 */
class ArrayStack2 {
    private final int maxSize; // 栈的元素最大数量
    private final int[] stack; // 数组模拟栈,数据就放在数组中
    private int top = -1; // 栈顶 初始化-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }


    /**
     * 返回当前栈顶
     *
     * @return
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 判断栈是否满
     *
     * @return
     */
    public boolean isFull() {
        return maxSize - 1 == top;
    }

    /**
     * 判断栈是否空
     *
     * @return
     */
    public boolean isEmpty() {
        return -1 == top;
    }

    /**
     * 入栈
     *
     * @param data
     */
    public void push(int data) {
        if (isFull()) {
            System.out.println("isFull:" + data);
            return;
        }
        top++;
        // 数据压入栈顶
        this.stack[top] = data;

    }

    /**
     * 出栈
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        int i = stack[top];
        System.out.println("pop:" + i);
        top--;
        return i;
    }

    /**
     * 遍历栈
     * 需要从栈顶开始往下遍历
     */
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }

        // 定义一个临时变量
        int index = top;

        while (index != -1) {
            System.out.println("list:" + stack[index]);
            index--;
        }
    }

    // 返回运算符优先级, 优先级使用数字表示,数字越大 优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }

    }

    // 判断是否为操作符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}