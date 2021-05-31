package com.hwei.structure.linkedlist;

/**
 * 双向链表
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "无用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林聪", "豹子头");
        HeroNode2 heroNode5 = new HeroNode2(5, "giao", "啊giao");

        // 创建一个链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.add(heroNode5);
        doubleLinkedList.show();


        heroNode5.name = "giao2";
        doubleLinkedList.updateByNo(heroNode5);
        System.out.println("修改后");
        doubleLinkedList.show();

        doubleLinkedList.del(heroNode3);
        System.out.println("删除后");
        doubleLinkedList.show();


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
     * 按编号修改节点
     *
     * @param heroNode2
     */
    public void updateByNo(HeroNode2 heroNode2) {

        HeroNode2 temp = getHead();

        while (true) {

            if (temp.next == null) {
                return;
            }

            // 找到改编号的节点
            if (temp.next.no == heroNode2.no) {

                // 配置新节点的下指针
                heroNode2.next = temp.next.next;

                // 配置新节点的前指针指向前一个节点
                heroNode2.pre = temp.next;

                // 配置新节点的前一个节点指向新节点
                temp.next = heroNode2;

                break;
            }

            // 指针位移
            temp = temp.next;
        }
    }

    /**
     * 添加一个节点到链表尾部
     *
     * @param node
     */
    public void add(HeroNode2 node) {

        // 使用一个辅助节点找到最后一个节点
        HeroNode2 temp = getHead();

        // 遍历找到最后一个节点
        while (true) {
            if (temp.next == null) {

                // 最后节点的下一个节点指向新节点
                temp.next = node;

                // 新节点的新节点指向最后节点
                node.pre = temp;
                break;
            }

            temp = temp.next;
        }
    }


    /**
     * 删除节点
     *
     * @param heroNode2
     */
    public void del(HeroNode2 heroNode2) {

        // 直接使当前节点失去引用
        heroNode2.pre.next = heroNode2.next;
        heroNode2.next.pre = heroNode2.pre;

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
    public HeroNode2 pre; // 指向前一个节点,默认null

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



