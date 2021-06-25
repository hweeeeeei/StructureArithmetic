package com.hwei.structure.stack;

/**
 * 数组实现栈
 */
public class ArrayStackDemo {

    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(5);

        arrayStack.push(11);
        arrayStack.push(12);
        arrayStack.push(13);
        arrayStack.push(14);
        arrayStack.push(15);
        arrayStack.push(16);

        arrayStack.list();

        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();

    }


}

/**
 * 定义一个类 表示栈
 */
class ArrayStack {
    private final int maxSize; // 栈的元素最大数量
    private final int[] stack; // 数组模拟栈,数据就放在数组中
    private int top = -1; // 栈顶 初始化-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
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
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        System.out.println("pop:" + stack[top]);
        top--;
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
}