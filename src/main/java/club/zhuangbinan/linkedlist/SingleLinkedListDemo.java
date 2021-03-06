package club.zhuangbinan.linkedlist;

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
//        linkedList.addWithoutOrder(heroNode1);
//        linkedList.addWithoutOrder(heroNode2);
//        linkedList.addWithoutOrder(heroNode3);

        linkedList.list();
//        HeroNode lastHeroNode = linkedList.getLastHeroNode();
//        System.out.println(lastHeroNode);

//        HeroNode firstHeroNode = linkedList.getFirstHeroNode();
//        System.out.println(firstHeroNode);

        ////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////

        SingleLinkedList linkedListWithOrder = new SingleLinkedList();
        HeroNode heroNode4= new HeroNode(4,"宋江","及时雨");
        HeroNode heroNode5= new HeroNode(5,"卢俊义","玉麒麟");
        HeroNode heroNode6= new HeroNode(6,"林冲","豹子头");
        HeroNode heroNode7= new HeroNode(7,"鲁智深","花和尚");


        linkedListWithOrder.addByOrder_WriteByMySelf(heroNode6);
        linkedListWithOrder.addByOrder_WriteByMySelf(heroNode7);
        linkedListWithOrder.addByOrder_WriteByMySelf(heroNode4);
        linkedListWithOrder.addByOrder_WriteByMySelf(heroNode6);
        linkedListWithOrder.addByOrder_WriteByMySelf(heroNode5);
        linkedListWithOrder.list();

        ////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////
        SingleLinkedList linkedListWithOrderByTeacher = new SingleLinkedList();
        HeroNode heroNode11= new HeroNode(11,"宋江","及时雨");
        HeroNode heroNode12= new HeroNode(12,"卢俊义","玉麒麟");
        HeroNode heroNode13= new HeroNode(13,"林冲","豹子头");
        HeroNode heroNode14= new HeroNode(14,"鲁智深","花和尚");


        linkedListWithOrderByTeacher.addByOrder_WriteByTeacher(heroNode12);
        linkedListWithOrderByTeacher.addByOrder_WriteByTeacher(heroNode11);
        linkedListWithOrderByTeacher.addByOrder_WriteByTeacher(heroNode13);
        linkedListWithOrderByTeacher.addByOrder_WriteByTeacher(heroNode14);
        linkedListWithOrderByTeacher.addByOrder_WriteByTeacher(heroNode11);
        linkedListWithOrderByTeacher.list();

        HeroNode willUpdateNode= new HeroNode(15,"小改改","孙尚香");
        linkedListWithOrderByTeacher.addByOrder_WriteByMySelf(willUpdateNode);
        linkedListWithOrderByTeacher.update(new HeroNode(11,"小姐姐","和黄狗"));

        linkedListWithOrderByTeacher.list();
        System.out.println("当前单向链表长度:"+linkedListWithOrderByTeacher.getLength(linkedListWithOrderByTeacher.getHead()));
        System.out.println();
        linkedListWithOrderByTeacher.deleteByNo(15);
        linkedListWithOrderByTeacher.deleteByNo(11);
        linkedListWithOrderByTeacher.deleteByNo(12);
        linkedListWithOrderByTeacher.deleteByNo(13);
        linkedListWithOrderByTeacher.deleteByNo(14);
        linkedListWithOrderByTeacher.list();
        System.out.println("当前单向链表长度:"+linkedListWithOrderByTeacher.getLength(linkedListWithOrderByTeacher.getHead()));


        linkedListWithOrderByTeacher.addByOrder_WriteByTeacher(heroNode11);
        linkedListWithOrderByTeacher.addByOrder_WriteByTeacher(heroNode12);
        linkedListWithOrderByTeacher.addByOrder_WriteByTeacher(heroNode13);
        linkedListWithOrderByTeacher.addByOrder_WriteByTeacher(heroNode14);

        linkedListWithOrderByTeacher.list();
        int descIndex = 2;
        HeroNode anyOneElementDescByIndex = linkedListWithOrderByTeacher.getAnyOneElementDescByIndex(linkedListWithOrderByTeacher.getHead(), descIndex);
        System.out.println("当前渠道的倒数第"+descIndex+"个元素为:"+anyOneElementDescByIndex);

        //p22 腾讯面试题,要把一个单项链表反转
        SingleLinkedList linkedListTx = new SingleLinkedList();
        HeroNode reverse101 = new HeroNode(101,"101","101");
        HeroNode reverse102 = new HeroNode(102,"102","102");
        HeroNode reverse103 = new HeroNode(103,"103","103");
        HeroNode reverse104 = new HeroNode(104,"104","104");

        linkedListTx.addByOrder_WriteByTeacher(reverse101);
        linkedListTx.addByOrder_WriteByTeacher(reverse102);
        linkedListTx.addByOrder_WriteByTeacher(reverse103);
        linkedListTx.addByOrder_WriteByTeacher(reverse104);
        linkedListTx.list();
        System.out.println("我自己的写法");
//        linkedListTx.reverseByMySelfChoiceMethodNum(1);
//        linkedListTx.reverseByMySelfChoiceMethodNum(2);
        linkedListTx.reverseByMySelfChoiceMethodNum(3);
        System.out.println();
        linkedListTx.list();
        //P22 老师的思路写法
        linkedListTx.reverseByTeacher();
        System.out.println("老师的思路写法转换后");
        linkedListTx.list();

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
     * 添加 方法 韩顺平老师写的 比我自己写的巧妙得多
     * 按 no 顺序添加,从小到大 1 2 3 4 5
     * @param heroNode 要添加的 HeroNode
     */
    public void addByOrder_WriteByTeacher(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;//标识要添加的新元素的编号是否已经存在,默认为false,存在时置为true
        while (true) {
            if (temp.getNext() == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.getNext().getNo() > heroNode.getNo()) {//位置找到,在temp的后面插入
                break;
            } else if (temp.getNext().getNo() == heroNode.getNo()){//说明希望添加的编号已经存在
                flag = true;
                break;
            }
            temp = temp.getNext(); //没找到 ,后移再找
        }
        if (flag) { //处理编号存在的情况
            System.out.println("当前编号已经存在:"+heroNode.getNo());
        }else {//处理找到了的情况. 找到了就要建立新的关系了
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
    }

    /**
     * 添加 方法 我自己写的,我分成几部分来处理,我的方法明显花的篇幅要大一些,我自以为的效率提升有没有呢?我暂时也未可知
     * 2022年1月27日17:04:50
     * 按 no 顺序添加,从小到大 1 2 3 4 5
     * @param heroNode 要添加的 HeroNode
     */
    public void addByOrder_WriteByMySelf(HeroNode heroNode) {
        //循环遍历这个Node
        //在遍历之前,先判断是不是在第一个插入, 或者在最后一个插入,如果是的,则插入时省去遍历的时间,效率更高
        //第一个
        if (head.getNext() == null) {
            head.setNext(heroNode);
            return;
        }
        //判断有没有相同no的,如果有,不能添加
        if (checkSameNo(heroNode)){  //缺点:每次添加都从头至尾遍历一次
            return;
        }
        //最后一个
        if (getLastHeroNode().getNo() < heroNode.getNo()) {
            this.getLastHeroNode().setNext(heroNode);
            return;
        }
        HeroNode temp = head.getNext();
        //头节点和第一个节点之间
        if (heroNode.getNo() < this.getFirstHeroNode().getNo()) {
            head.setNext(heroNode);
            heroNode.setNext(temp);
            return;
        }
        //在中间插入
        while (true) {
            //第一个节点 - 最后一个节点之间
            if (heroNode.getNo() < temp.getNext().getNo()) {
                heroNode.setNext(temp.getNext()); //注意: 链表要把新加入的那个先接后面一个,再把前面那个的后一个指向新加入的那个
                temp.setNext(heroNode); //这两行搞反了会出现引用死循环
                break;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 按照 no 删除一个节点
     * @param no 删除参数
     * @return 删除节点个数
     */
    public int deleteByNo(int no) {
        HeroNode temp = head;
        if (temp.getNext() == null) {
            System.out.println("链表为空");
            return 0;
        }
        boolean flag = false;
        while (true) {
            if (temp.getNext() == null) {
                break;//到最后
            }
            if (temp.getNext().getNo() == no) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            //找到了位置,删除
            HeroNode willDel = temp.getNext();//是要删除掉的
            HeroNode willConnect = willDel.getNext();
            temp.setNext(willConnect);
            willDel.setNext(null);
            return 1;
        }else{
            System.out.println("没有找到要删除的节点:"+no);
            return 0;
        }
    }

    /**
     * 根据HeroNode的no来修改链表中的HeroNode
     * @param heroNode 修改参数
     */
    public int update(HeroNode heroNode) {
        HeroNode temp = head;
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return 0;
        }
        boolean flag = false;
        while (true) {

            if (temp.getNext() == null) {
                break;
            }
            if (temp.getNext().getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }

        if (flag) {
            temp.getNext().setName(heroNode.getName());
            temp.getNext().setNickname(heroNode.getNickname());
            return 1;
        }else {
            System.out.println("没有找到需要修改节点:"+heroNode.getNo());
            return 0;
        }
    }

    /**
     * 判断新添加的参数的no在链表中是否已经存在
     * @param heroNode 将要被审查的 HeroNode
     * @return 存在返回 true , or false
     */
    private boolean checkSameNo(HeroNode heroNode){
        //遍历整个链表,对no进行比对
        HeroNode temp = getFirstHeroNode();
        while (true) {
            if (temp.getNext() == null) { //遍历到最后一个也没有相等的
                return false; //返回false
            }
            if (temp.getNo() == heroNode.getNo()) {
                System.out.println("该链表已经存在编号为:" + heroNode.getNo() + "的HeroNode");
                return true;
            }
            temp = temp.getNext();
        }
    }

    /**
     * 获取第一个节点,不是头节点
     * @return 第一个节点
     */
    public HeroNode getFirstHeroNode(){
        HeroNode temp = head.getNext();
        if (temp == null) { //得避免空指针异常
            throw new NoSuchElementException("链表中还没有节点");
        }
        return temp;
    }

    /**
     * 获取尾节点
     * @return 尾节点
     */
    public HeroNode getLastHeroNode() {
        HeroNode temp = head.getNext();
        if (temp == null) { //得避免空指针异常
            return null;
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

    /**
     * p22 腾讯面试题 给单项链表反转
     * 我自己写的
     * @param methodNum 选一种实现方式,1,2,3
     */
    public void reverseByMySelfChoiceMethodNum(int methodNum) {
        HeroNode temp = head.getNext();
        if (temp == null || temp.getNext() == null) {
//            throw new IllegalArgumentException("这个单链表没有元素");//没必要抛出异常
            //直接返回就好
            // 加上 || temp.getNext()==null 对只有一个节点的情况进行判断,提高效率;看了老师写的后改的
            return;
        }
        //思路:
        //1.创建一个新的HeroNode reverseHead
        //2.遍历参数的节点,从末尾开始拿节点,把拿到的节点放到reverseHead,删除原来的参数的节点
        //3.遍历结束后,把参数的head.next = reverseHead.next
        SingleLinkedList reverseList = new SingleLinkedList();
        HeroNode reverseHead = reverseList.getHead();
        int length = getLength(getHead());

        switch (methodNum) {
            case 1:
                for (int i = 0; i < length; i++) {
                    HeroNode lastHeroNode = getLastHeroNode();
                    if (lastHeroNode != null) {
                        reverseHead.setNext(lastHeroNode);
                        this.deleteByNo(lastHeroNode.getNo());
                        reverseHead = reverseHead.getNext(); //指针移到下一层;隔了1天我自己写的代码都看不懂了...
                    }else{
                        break;
                    }
                }
                head.setNext(reverseList.getHead().getNext());
                reverseList = null;
                break;
            case 2:
                for (int i = 0; i < length; i++) {
                    HeroNode lastHeroNode = getLastHeroNode();
                    if (lastHeroNode != null) {
                        reverseList.addWithoutOrder(lastHeroNode); //case 1 就是为了完成这个效果;
                        this.deleteByNo(lastHeroNode.getNo());
                    }else{
                        break;
                    }
                }
                head.setNext(reverseList.getHead().getNext());
                break;
            case 3:
                //不创建SingleLinkedList对象来做
                HeroNode newHead = new HeroNode(0,"",""); //创建头节点
                //新的链表的指针,和case 1 差不多
                HeroNode cur = newHead;
                while (head.getNext() != null) {
                    HeroNode lastHeroNode = getLastHeroNode();
                    cur.setNext(lastHeroNode);
                    cur = cur.getNext();
                    deleteByNo(lastHeroNode.getNo());
                }
                head.setNext(newHead.getNext());
                break;
        }

    }

    /**
     * p22 腾讯面试题 给单项链表反转
     * 老师的思路 和我思路有差别
     * 老师的是从第一个节点开始取,我是从最后一个节点取
     * 从第一个节点取, 那么在新的链表插入时,也总是要从头结点处插入
     * 可以叫头插法吗 ? 2022年1月29日15:47:04
     */
    public void reverseByTeacher() {
        HeroNode temp = head.getNext();
        if (temp == null || temp.getNext() == null) {
            return;
        }
        HeroNode cur = temp;  //定义一个辅助指针 ,帮助我们遍历原来的链表
        HeroNode next = null; //指向当前[cur]节点的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");

        //遍历到最后一个节点,遍历原来的链表
        //每遍历一个节点,就将其取出,并放在新的链表reverseHead的最前端
        while (cur != null) {
            //1.从源链表取第一个节点,保存起来,cur = temp就是保存起来了
            next = cur.getNext(); // 把第第一个节点的下一个节点保存起来
            //2.把源链表拿出来那个节点放到新链表的第一个
            cur.setNext(reverseHead.getNext());
            //3.把新链表的头节点和新拿过来的节点连接
            reverseHead.setNext(cur);
            //4.cur后移
            cur = next;
        }
        head.setNext(reverseHead.getNext());//把转换好额链表设置回原链表
    }


    /**
     * 获取倒数第 K 个节点
     * @param head 需要处理的单项链表头
     * @param index 第 K 个
     * @return HeroNode
     */
    public HeroNode getAnyOneElementDescByIndex(HeroNode head,int index) {
        HeroNode temp = head.getNext();
        if (temp == null) {
            return null;
        }
        int length = getLength(head);
        if (index <= 0 || index > length) {
            throw new IllegalArgumentException("参数不正确index="+index);
        }
        for (int i = 0; i < length - index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }


    public HeroNode getHead(){
        return this.head;
    }

    /**
     *
     * @param head 单项链表头
     * @return 单项链表有效元素个数
     */
    public int getLength(HeroNode head) {
        if (head.getNext() == null) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head.getNext();
        while (temp != null) {
            length ++ ;
            temp = temp.getNext();
        }
        return length;
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
