package com.hwei.structure.linkedlist;

/**
 * 双向链表
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {


    }
}


class DoubleLinkedList {

    /**
     * 初始化一个头节点
     */
    private final HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 遍历双向链表
     * 为什么需要辅助变量? 因为head不能动
     */
    public void show() {
        // 先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        // 因为头节点不为空 需要一个辅助变量来辅助
        HeroNode2 temp = head.next;

        while (true) {
            String string = temp.toString();
            System.out.println(string);
            System.out.println();

            temp = temp.next;

            if (temp == null) {
                break;
            }
        }
    }


}


class HeroNode2 {

    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; // 指向下一个节点,默认null
    public HeroNode pre; // 指向前一个节点,默认null

    public HeroNode2(int hNo, String hName, String hNickname) {
        no = hNo;
        name = hName;
        nickname = hNickname;
    }

    // 重写toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
//                ", next=" + next +
                '}';
    }
}



