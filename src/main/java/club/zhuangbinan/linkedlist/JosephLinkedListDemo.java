package club.zhuangbinan.linkedlist;

/**
 * 约瑟夫问题
 * 有 n个小孩围成1个圈,从固定编号 k(1<=k<=n)的那个人开始数,数 m下 ,出列1个小孩, 他的下一位又开始数m下,然后出列, 直到只剩 1个小孩(或者说所有人出列为止),
 * 由此产生一个出列编号的序列
 * 实例:
 * n=5,k=1,m=2
 * 1,2,3,4,5 ,5又连接1组成一个环 , 从1开始数m=2下,1,2 , 2出列
 * 剩1,3,4,5  ,从2的下一个开始数 3,4 , 4出列
 * 剩1,3,5,  5,1 , 1出列
 * 剩3,5 ,  ,5出列
 * 剩3 也出列
 * 出列序列 =  2,4,1,5,3
 * <p>
 * 参考老师的用单向环形链表来实现
 */
public class JosephLinkedListDemo {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

//        int k = 2;
//        for (int i = 0; i < k - 1; i++) {
//            System.out.println("sss");
//        }
        circleSingleLinkedList.countBoy(1,2,5);

    }

}

//创建一个环形的单向链表
class CircleSingleLinkedList {

    private Boy first = null;

    /**
     * 根据用户的输入,计算出小孩出圈的顺序
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几次
     * @param nums     表示最初一共有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误 , 请重新输入");
            return;
        }
        //创建辅助指针帮助小孩出圈
        Boy helper = first;
        //辅助指针实现应该指向环形链表的最后这个节点
        //循环找到最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;//说明helper指向最后一个小孩节点
            }
            helper = helper.getNext();
        }
        //小孩报数前,先让first和helper移动k-1次, 这是为了满足 "出列1个小孩, 他的下一位又开始数m下", 要从下一个开始报数
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //小孩报数时,让first和helper指针同时移动 m-1 次,然后出圈 (m=countNum)
        //循环到圈中只有1个人
        while (true) {
            if (helper == first) {
                //说明圈中只有1人
                System.out.printf("最后留在圈中的小孩编号%d\n",first.getNo());
                break;
            }
            //让 first 和 helper 指针同时 的移动 countNum -1
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这是first指向的节点,就是要出圈的小孩节点
            System.out.printf("小孩%d 出圈\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
    }

    public void addBoy(int nums) {
        //给nums做校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;
        //用For创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环
                curBoy = first;//指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy() {
        if (first == null) {
            System.out.println("环形链表为空");
            return;
        }
        //因为first不能动,因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
//                System.out.println("链表已经遍历完了");
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

}

class Boy {

    private int no;

    private Boy next;

    public Boy(int no) {
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












