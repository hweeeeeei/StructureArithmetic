package com.hwei.structure.queue;

/**
 * 环形 数组队列模拟
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {

        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);

        circleArrayQueue.addQueue(2);
        circleArrayQueue.addQueue(5);
        circleArrayQueue.addQueue(8);

        circleArrayQueue.addQueue(9);

        circleArrayQueue.show();

        System.out.println("getQueue:" + circleArrayQueue.getQueue());

        circleArrayQueue.addQueue(19);
        circleArrayQueue.show();




    }
}

class CircleArrayQueue {

    private int maxSize; //最大容量
    private int front; // 队列头 指向第一个元素
    private int rear; //队列尾 指向最后一个元素的后一个位置
    private int[] arr; // 存放数据

    public CircleArrayQueue(int maxSize) {

        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];

    }

    //判断队列已满
    public boolean isFull() {

        return (rear + 1) % maxSize == front;
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
            System.out.println("addQueue已满:" + n);
            return;
        }

        //2.将数据存入数据
        this.arr[rear] = n;

        // 3.后指针位移  应该取模 不然下标会一直往后走 然后越界, 取模可以控制队列变为环形队列
        // 所以不能使用 rear++;
        rear = (rear + 1) % maxSize;
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

        // 2. 获取当前值保存
        int i = arr[front];

        // 3. 前指针位移, 后移也要考虑取模,不取模,下标会一直往上走 会越界
        front = (front + 1) % maxSize;

        return i;

    }

    public void show() {
        boolean empty = isEmpty();
        if (empty) {
            System.out.println("队列已空,不能show");
        }

//        // 不能再便利所有数组, 因为有的已经被取出过了
//        for (int i : arr) {
//            System.out.print(i + "\t");
//        }

        // 思路: 从front开始遍历,遍历多少元素
        for (int i = front; i < front + size(); i++) {

            System.out.println(i % maxSize + ",show:" + arr[i % maxSize]);
        }

    }

    // 显示队列头 不是取出数据
    public int headQueue() {

        boolean empty = isEmpty();
        if (empty) {
            System.out.println("队列已空,不能headQueue");
            throw new RuntimeException("队列已空,不能headQueue");
        }

        return this.arr[front];
    }


    // 当前队列有效数据的个数
    public int size() {
        // rear =1  front=0  maxSize=3
        return (rear + maxSize - front) % maxSize;
    }


}
