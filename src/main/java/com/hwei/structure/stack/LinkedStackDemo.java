package com.hwei.structure.stack;

/**
 * 用链表实现栈结构
 */
public class LinkedStackDemo {

    public static void main(String[] args) {

        LinkedStack linkedStack = new LinkedStack(4);

        linkedStack.push(1);

        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);

        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();

        linkedStack.push(5);
//
    }

}


/**
 * 单链表模拟栈
 */
class LinkedStack {
    private final int maxSize;
    private int length = 0;
    private LinkedStackNode stack;

    public LinkedStack(int maxSize) {
        if (maxSize < 1) {
            throw new RuntimeException("maxSize <1");
        }
        this.maxSize = maxSize;
    }

    /**
     * 出栈
     */
    public void pop() {

        if (isEmpty()) {
            throw new RuntimeException("isEmpty");
        }
        System.out.println("pop:" + stack.getData());

        //  将当前节点失去引用
        stack = stack.getNext();

        // 长度-1
        length--;
    }

    /**
     * 入栈
     *
     * @param data
     */
    public void push(int data) {
        if (isFull()) {
            throw new RuntimeException("isFull:" + data);
        }

        // 新节点
        LinkedStackNode node = new LinkedStackNode();
        node.setData(data);

        // 如果是是第一个
        if (length == 0) {
            this.stack = node;
        } else {
            // 将新元素的加入栈顶
            node.setNext(stack);
            stack = node;
        }
        System.out.println("push:" + data);
        // 长度递增
        length++;
    }

    // 满
    public boolean isFull() {
        return length == maxSize;
    }

    // 空
    public boolean isEmpty() {
        return length == 0;
    }

}


/**
 * 栈 节点
 */
class LinkedStackNode {
    private int data; // 数据
    private LinkedStackNode next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedStackNode getNext() {
        return next;
    }

    public void setNext(LinkedStackNode next) {
        this.next = next;
    }
}
