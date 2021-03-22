package com.hwei.structure.linkedlist;


/**
 * 单链表  +   按id排序的单链表
 */
public class SingleLinkedListDemo {



    public static void main(String[] args) {

        // 创建几个节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "无用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林聪", "豹子头");
        HeroNode heroNode5 = new HeroNode(5, "giao", "啊giao");

        // 创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode4);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);

        singleLinkedList.addSort(heroNode1);
        singleLinkedList.addSort(heroNode4);
        singleLinkedList.addSort(heroNode2);
        singleLinkedList.addSort(heroNode5);
        singleLinkedList.addSort(heroNode5);
        singleLinkedList.addSort(heroNode3);

        singleLinkedList.show();
        System.out.println("----");

        // 修改
        heroNode5.nickname = "啊giao222";
        singleLinkedList.updataNode(heroNode5);
        singleLinkedList.show();


        System.out.println("----");
        singleLinkedList.delNode(5);
        singleLinkedList.show();

        System.out.println("个数为" + SingleLinkedList.getLength(singleLinkedList.getHead()));

        singleLinkedList.getByDesc(2);

        // 反转
        HeroNode reverseNode = singleLinkedList.reverseLinked(singleLinkedList.getHead());
        System.out.println("----");

    }

}

/**
 * 定义SingleLinkedList,管理英雄
 */
class SingleLinkedList {

    /**
     * 初始化一个头节点
     */
    private final HeroNode head = new HeroNode(0, "", "");


    /**
     * 获取单链表
     * 去掉头节点
     *
     * @return
     */
    public static int getLength(HeroNode head) {

        if (head.next == null) {
            return 0;
        }

        int length = 0;

        HeroNode cur = head.next;

        while (cur != null) {
            length++;
            cur = cur.next;
        }

        return length;
    }

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到单项链表
     * 思路: 当不考虑编号的顺序时:
     * 1. 找到链表最后的节点
     * 2. 找到最后节点的next,指向新节点
     */
    public void add(HeroNode heroNode) {

        // 因为head节点不能动, 所有需要一个辅助遍历
        HeroNode temp = head;

        while (true) {
            // 找到最后一个节点
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }

            // 如果没有找到 将temp后移
            temp = temp.next;
        }

    }


    /**
     * 反转单链表 腾讯面试题
     *
     * @param
     * @return
     */
    public HeroNode reverseLinked(HeroNode head) {

        if (head.next == null) {
            return null;
        }

        // 反转后的节点
        HeroNode reverse = new HeroNode(0, "", "");
        // 辅助遍历用的节点
        HeroNode cur = head.next;
        HeroNode next;

        while (cur !=null) {

            // 暂存下一个节点
            next = cur.next;

            // 插入到reverse前面
            cur.next = reverse.next;

            // 连接到新的链表上
            reverse.next = cur;

            // cur后移
            cur = next;
        }
        return reverse;
    }


    public void addSort(HeroNode heroNode) {

        // 因为head节点不能动, 所有需要一个辅助遍历,来找到添加的位置
        HeroNode temp = head;

        // 循环遍历链表
        while (true) {

            // 已经到了最后
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }

            // 找到no比我大的节点,将当前节点插入到中间
            if (temp.next.no > heroNode.no) {

                // 将比我大的no编号,设置为当前节点的下一个节点
                heroNode.next = temp.next;

                // 将当前找到的节点的下一个节点 设置为 新添加进来的节点,  因为此时新添加的节点 已经将比我大的no的节点包含在内, 又形成了一个链条
                temp.next = heroNode;

                break;
            }

            // 如果已经存在当前no
            if (temp.next.no == heroNode.no) {
                System.out.println("已经存在" + heroNode.no);
                break;
            }
            // 如果没有找到 需要位移
            temp = temp.next;
        }

    }


    /**
     * 删除链表中的节点
     * 1. 先找到要删除节点的前一个节点
     * 2. temp.next=temp.next.next , 直接使这个节点失去引用
     */
    public void delNode(int no) {

        // 找到需要删除的节点的前一个节点
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                // 直接使这个节点失去引用 会被GC回收
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 按no编号修改 链表的属性
     * no编号不能改
     *
     * @param heroNode 修改后的内容
     */
    public void updataNode(HeroNode heroNode) {

        // 1.找到需要修改的节点的下一个节点, 需要一个辅助指针来完成
        HeroNode temp = head;

        while (true) {

            if (temp.next == null) {
                System.out.println("没有找到该节点");
                break;
            }

            // 找到该节点
            if (temp.next.no == heroNode.no) {

                // 将旧节点的next连接到替换节点的next
                heroNode.next = temp.next.next;

                // 旧节点的上个节点 指向新节点
                temp.next = heroNode;
                break;
            }

            // 指针下移
            temp = temp.next;
        }
    }

    /**
     * 查找单链表倒数的第K个元素（新浪）
     * <p>
     * 1. 先计算总个数
     * 2. 要查找的元素位置=总个数-k
     * 3. 注意下标边界值，判断下标不能<0
     *
     * @param k 下标
     * @return
     */
    public void getByDesc(int k) {

        //1. 先计算总个数
        int length = getLength(head);

        // 计算出正数是顺序位置
        int index = length - k;

        // 判断边界
        if (k < 0 || k > index) {
            System.out.println("超出边界");
        }

        // 辅助变量
        HeroNode temp = head.next;

        // 记录当前下标 辅助变量
        int count = 0;

        //找到这个位置的元素
        while (true) {

            if (temp == null) {
                return;
            }
            if (count == index) {
                System.out.println("找到了" + temp.nickname);
                return;
            }

            // 下标位移
            count++;

            // 节点位移
            temp = temp.next;
        }

    }

    /**
     * 显示链表
     * 为什么需要辅助变量? 因为head不能动
     */
    public void show() {
        // 先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        // 因为头节点不为空 需要一个辅助变量来辅助
        HeroNode temp = head.next;

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

class HeroNode {

    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int hNo, String hName, String hNickname) {
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
