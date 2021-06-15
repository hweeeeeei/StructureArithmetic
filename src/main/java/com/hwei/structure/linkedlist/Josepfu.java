package com.hwei.structure.linkedlist;

/**
 * 约瑟夫环
 * 约瑟夫问题
 * 单向环形链表
 */
public class Josepfu {

    public static void main(String[] args) {

        CircleSingleLinkList circleSingleLinkList = new CircleSingleLinkList();

        // 初始化人数
        circleSingleLinkList.initBoy(50000);

        // 遍历
        circleSingleLinkList.show();

        // 报数
        circleSingleLinkList.popBoy(100, 4000, 50000);
    }
}

// 单向环形链表
class CircleSingleLinkList {

    //创建一个first节点,当前没有编号
    private Boy first = null;

    /**
     * 根据用户输入 让小孩出圈
     *
     * @param startNo  从第几个开始数
     * @param countNum 数几下
     * @param nums     共有多少
     */
    public void popBoy(int startNo, int countNum, int nums) {

        // 对数据进行校验
        if (first == null) {
            System.out.println("first == null");
            return;
        }
        if (startNo <= 0) {
            System.out.println("startNo <= 0");
            return;
        }
        if (startNo > nums) {
            System.out.println("startNo > nums");
            return;
        }

        // 辅助指针   指向链表最后一个节点
        Boy helper = first;

        // 找到最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            } else {
                // 指针位移
                helper = helper.getNext();
            }
        }

        // 报数前, 移动到开始报数的位置,  first和helper 移动  k-1次
        for (int i = 0; i < startNo - 1; i++) {
            // 指针位移
            first = first.getNext();
            // 指针位移
            helper = helper.getNext();
        }

        // 开始报数 first 和helper同时移动m-1次 , 循环出圈
        //  一个循环操作, 直到圈中只有一个人
        while (true) {
            if (helper == first) {
//                System.out.println("最后节点");
                break;
            } else {

                //first 和helper同时移动m-1次
                for (int i = 0; i < countNum - 1; i++) {
                    // 指针位移
                    first = first.getNext();
                    // 指针位移
                    helper = helper.getNext();
                }

                // 循环后 first 指向的节点 就是需要出圈的节点
                System.out.println("出圈" + first.getNo());

                // 出圈操作
                first = first.getNext();
                helper.setNext(first);

            }
        }
        System.out.println("最后留在圈中" + first.getNo());

    }

    // 初始化添加小孩节点,构成环形的链表
    public void initBoy(int nums) {
        // 对nums数据校验
        if (nums < 1) {
            System.out.println("nums不正确");
            return;
        }

        // 辅助遍历 帮助遍历
        Boy curBoy = null;

        // 使用for 创建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                // 第一个节点
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {

                // 设置上一个节点的下个节点为当前节点
                curBoy.setNext(boy);
                boy.setNext(first);

                // 辅助指针后移
                curBoy = boy;
            }
        }
    }

    // 遍历环形链表
    public void show() {

        // 复制遍历 指针
        Boy curBoy = first;

        while (true) {

            System.out.println("小孩的编号:" + curBoy.getNo());

            // 指针位移1
            curBoy = curBoy.getNext();
            if (curBoy == first) {
                return;
            }
        }
    }
}

// Boy类 表示节点
class Boy {
    private int no; // 编号
    private Boy next; // 指向下一个节点,默认nukk

    Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}