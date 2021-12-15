package club.zhuangbinan.linkedlist;

/**
 * 单向链表demo
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        HeroNode heroNode1= new HeroNode(1,"songjiang","laoda");
        HeroNode heroNode2= new HeroNode(2,"lujunyi","laoer");
        HeroNode heroNode3= new HeroNode(3,"linchong","laosan");
        linkedList.add(heroNode2);
        linkedList.add(heroNode1);
        linkedList.add(heroNode3);

        linkedList.list();
        HeroNode lastHeroNode = linkedList.getLastHeroNode();
        System.out.println(lastHeroNode);

        HeroNode firstHeroNode = linkedList.getFirstHeroNode();
        System.out.println(firstHeroNode);

    }
}

class SingleLinkedList {
    private HeroNode heroNode = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        if (this.heroNode.getNext() == null) {
            this.heroNode.setNext(heroNode);
        }else {
            getLastHeroNode().setNext(heroNode);
        }
    }

    public HeroNode getFirstHeroNode(){
        return heroNode.getNext();
    }

    public HeroNode getLastHeroNode() {
        HeroNode temp = heroNode.getNext();
        while (true) {
            if (temp.getNext() == null) {
                return temp;
            }
            temp = temp.getNext();
        }
    }

    public void list() {
        HeroNode temp = heroNode.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

}

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

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
