package club.zhuangbinan.queue;

import java.util.Scanner;

/**
 * 缺点:数组模拟的队列只能用一次,不能复用
 */
public class ArrayQueueWithScannerDemo {


    public static void main(String[] args) {
        showArrayQue();
    }

    public static void showArrayQue(){
        Scanner scanner = new Scanner(System.in);
        char key;
        boolean loop = true;
        ArrayQueueTest que = new ArrayQueueTest(3);
        while (loop) {
            System.out.println("请按如下提示输入:");
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(addWithoutOrder): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            try {
                switch (key) {
                    case 's':
                        que.showQueue();
                        break;
                    case 'e':
                        System.out.println("退出程序");
                        loop = false;
                        break;
                    case 'a':
                        System.out.println("请再输入一个数字:");
                        que.addQueue(scanner.nextInt());
                        System.out.println("输入的数字被添加到队列中");
                        break;
                    case 'g':
                        System.out.println("取出的数字为:" + que.getQueue());
                        break;
                    case 'h':
                        System.out.println("队列头数据:" + que.getHeadQueue());
                        break;
                    default:
                        System.out.println("您的输入有误,请重新输入!");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        scanner.close();
    }

}

