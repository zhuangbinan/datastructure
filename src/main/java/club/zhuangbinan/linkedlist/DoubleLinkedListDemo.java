package club.zhuangbinan.linkedlist;

/**
 * 双向链表Demo
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.list();
        HeroNode2 h1 = new HeroNode2(1, "zhangsan", "法外狂徒");
        HeroNode2 h2 = new HeroNode2(2, "lisi", "邻居女孩");
        HeroNode2 h3 = new HeroNode2(3, "ww", "www-1");
        HeroNode2 h4 = new HeroNode2(4, "44", "www-44");
        HeroNode2 h5 = new HeroNode2(5, "55", "www-55");
        doubleLinkedList.add(h1);
        doubleLinkedList.add(h2);
        doubleLinkedList.add(h3);
//        doubleLinkedList.list();
//        doubleLinkedList.del(3);
//        doubleLinkedList.list();
//        doubleLinkedList.del(4);
//        doubleLinkedList.list();
//        doubleLinkedList.add(h3);
//        doubleLinkedList.del(2);
        doubleLinkedList.add(h4);
        doubleLinkedList.add(h5);
        doubleLinkedList.list();

        doubleLinkedList.deleteByNos(2, 3);

        doubleLinkedList.list();
        HeroNode2 heroNode2 = new HeroNode2(5,"update 555555","nickName 55555");
        doubleLinkedList.updateByNo(heroNode2);
        doubleLinkedList.list();

        System.out.println("=========================");

        HeroNode2 o1 = new HeroNode2(1, "zhangsan", "法外狂徒");
        HeroNode2 o2 = new HeroNode2(2, "lisi", "邻居女孩");
        HeroNode2 o3 = new HeroNode2(3, "ww", "www-1");
        HeroNode2 o6 = new HeroNode2(6, "66", "www-666");
        HeroNode2 o7 = new HeroNode2(7, "66", "www-777");
        DoubleLinkedList doubleLinkedListByNoOrder = new DoubleLinkedList();
        doubleLinkedListByNoOrder.addByNoOrder(o6);
        doubleLinkedListByNoOrder.addByNoOrder(o2);
        doubleLinkedListByNoOrder.addByNoOrder(o3);
        doubleLinkedListByNoOrder.addByNoOrder(o1);
        doubleLinkedListByNoOrder.addByNoOrder(o7);
        doubleLinkedListByNoOrder.list();
    }
}

/**
 * 双向链表 impl by myself
 */
class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(-1, "", "");

    public void list() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.getNext();

        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    /**
     * 课后作业完成 按照编号顺序添加 从小到大
     * @param heroNode2 HeroNode2
     */
    public void addByNoOrder(HeroNode2 heroNode2) {
        HeroNode2 temp = head.getNext();
        if (temp == null) {
            head.setNext(heroNode2);
            heroNode2.setPre(head);
            return;
        }
        while (temp != null) {
            if (temp.getNo() <= heroNode2.getNo()) {
                if (temp.getNext() == null) {
                    temp.setNext(heroNode2);
                    heroNode2.setPre(temp);
                    break;
                }else {
                    if (temp.getNext().getNo() > heroNode2.getNo()) {
                        heroNode2.setNext(temp.getNext());
                        heroNode2.setPre(temp);
                        temp.setNext(heroNode2);
                        break;
                    }
                    if (temp.getNext() != null) {
                        temp = temp.getNext();
                    }
                }
            }else {
                //如果是小于的,那放前面
                temp.getPre().setNext(heroNode2);
                heroNode2.setNext(temp);
                heroNode2.setPre(temp.getPre());
                temp.setPre(heroNode2);
                break;
            }
        }
    }

    /**
     * 默认添加到链表的末尾
     * @param heroNode2 需要添加的元素
     */
    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head.getNext();
        if (temp == null) {
            head.setNext(heroNode2);
            heroNode2.setPre(head);
        }
        while (temp != null) {
            if (temp.getNext() != null) {
                temp = temp.getNext();
            } else {
                temp.setNext(heroNode2);
                heroNode2.setPre(temp);
                break;
            }
        }
    }

    public void deleteByNos(Integer... nos) {
        for (int i = 0; i < nos.length; i++) {
            del(nos[i]);
        }
    }

    public void del(Integer no) {
        HeroNode2 temp = head;
        if (temp.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {

            HeroNode2 thisOne = temp.getNext();
            if (thisOne != null && thisOne.getNo() == no) {
                temp.setNext(thisOne.getNext());
                if (thisOne.getNext() != null) {
                    thisOne.getNext().setPre(temp);
                }
                break;
            }
            if (temp.getNext() != null) {
                temp = temp.getNext();
            } else {
                System.out.println("没找到你要删除的");
                break;
            }
        }

    }

    public void updateByNo(HeroNode2 no) {
        HeroNode2 temp = head;
        if (temp.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        while (true) {
            if (temp.getNo()==no.getNo()) {
                temp.setName(no.getName());
                temp.setNickname(no.getNickname());
                break;
            }
            if (temp.getNext() != null) {
                temp = temp.getNext();
            }else {
                System.out.println("没有找到符合条件的No");
                break;
            }
        }

    }

    public HeroNode2 getHead() {
        return this.head;
    }

}

class HeroNode2 {

    private int no;
    private String name;
    private String nickname;
    private HeroNode2 next;
    private HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public HeroNode2 getNext() {
        return next;
    }

    public void setNext(HeroNode2 next) {
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

    public HeroNode2 getPre() {
        return pre;
    }

    public void setPre(HeroNode2 pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
