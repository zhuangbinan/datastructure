package club.zhuangbinan.linkedlist;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 单向链表demo
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        HeroNode heroNode1= new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2= new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3= new HeroNode(3,"林冲","豹子头");
        linkedList.addWithoutOrder(heroNode2);
        linkedList.addWithoutOrder(heroNode1);
        linkedList.addWithoutOrder(heroNode3);

        linkedList.list();
        HeroNode lastHeroNode = linkedList.getLastHeroNode();
        System.out.println(lastHeroNode);

        HeroNode firstHeroNode = linkedList.getFirstHeroNode();
        System.out.println(firstHeroNode);

    }
}

/**
 * 头节点
 * SingleLinkedList
 */
class SingleLinkedList {

    //头结点不要动,不存放具体数据,在HeroNode的构造方法里,下一节点为null
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加
     * 不按 no 的顺序添加
     * @param heroNode 要添加的 HeroNode
     */
    public void addWithoutOrder(HeroNode heroNode) {
        if (this.head.getNext() == null) {//如果是第一个节点,就放在头节点后面
            this.head.setNext(heroNode);
        }else {
            //如果第一个节点以及存在,按照先后顺序,给放在节点的末尾
            getLastHeroNode().setNext(heroNode);
        }
    }

    /**
     * 添加
     * 按 no 顺序添加,从小到大 1 2 3 4 5
     * @param heroNode 要添加的 HeroNode
     */
    public void addByOrder(HeroNode heroNode) {
        //循环遍历这个Node
        //在遍历之前,先判断是不是在第一个插入, 或者在最后一个插入,如果是的,则插入时省去遍历的时间,效率更高

//        while (true) {
//            break;
//        }

    }

    /**
     * 获取第一个节点,不是头节点
     * @return 第一个节点
     */
    public HeroNode getFirstHeroNode(){
        return head.getNext();
    }

    /**
     * 获取尾节点
     * @return 尾节点
     */
    public HeroNode getLastHeroNode() {
        HeroNode temp = head.getNext();
        if (temp == null) { //得避免空指针异常
            throw new NoSuchElementException("链表中还没有节点");
        }
        while (true) {
            if (temp.getNext() == null) {
                return temp;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 列出所有的节点
     */
    public void list() {
        HeroNode temp = head.getNext();
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

}

/**
 * 一个 HeroNode 就是一个节点
 */
class HeroNode {

    private int no;
    private String name;
    private String nickname;
    private HeroNode next = null;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
