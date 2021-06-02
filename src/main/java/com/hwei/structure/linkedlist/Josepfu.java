package com.hwei.structure.linkedlist;

/**
 * 约瑟夫环
 * 约瑟夫问题
 */
public class Josepfu {

    public static void main(String[] args) {

        CircleSingleLinkList circleSingleLinkList = new CircleSingleLinkList();

        circleSingleLinkList.addBoy(3);


    }
}

// 单向环形链表
class CircleSingleLinkList {

    //创建一个first节点,当前没有编号
    private Boy first = null;

    // 添加小孩节点,构成环形的链表
    public void addBoy(int nums) {
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