package com.hwei.structure.queue;

/**
 * 数组队列模拟
 * 非环形队列
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        // 创建一个队列对象
        ArrayQueue arrayQueue = new ArrayQueue(3);

        arrayQueue.addQueue(1);
        arrayQueue.addQueue(5);
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(1);

        System.out.println(arrayQueue.getQueue());
        System.out.println(arrayQueue.getQueue());
        System.out.println(arrayQueue.getQueue());

        arrayQueue.addQueue(7);

        System.out.println(arrayQueue.getQueue());

    }
}

class ArrayQueue {

    private int maxSize; //最大容量
    private int front; // 队列头
    private int rear; //队列尾
    private int[] arr; // 存放数据

    public ArrayQueue(int maxSize) {

        this.maxSize = maxSize;
        // 初始化
        this.arr = new int[maxSize];

        this.front = -1; //指向队列头的前一个位置
        this.rear = -1; // 指向队列尾的数据,既包含队列最后一个数据

    }

    //判断队列已满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n) {

        // 1.判断队列已满
        boolean full = isFull();

        if (full) {
            System.out.println("已满" + n);
            return;
        }

        // 2.后指针位移
        rear++;

        //3.将数据存入数据
        this.arr[rear] = n;

    }

    /**
     * 出队列
     */
    public int getQueue() {

        // 1. 判空
        boolean empty = isEmpty();
        if (empty) {
            throw new RuntimeException("getQueue已空");
        }

        // 前指针位移
        front++;
        return arr[front];

    }

    public void show() {

        boolean empty = isEmpty();
        if (empty) {
            System.out.println("队列已空,不能show");

        }

        for (int i : arr) {
            System.out.print(i + "\t");
        }

    }

    // 显示队列头 不是取出数据
    public int headQueue() {

        boolean empty = isEmpty();
        if (empty) {
            System.out.println("队列已空,不能headQueue");

            throw new RuntimeException("队列已空,不能headQueue");
        }

        return this.arr[front + 1];

    }

}
