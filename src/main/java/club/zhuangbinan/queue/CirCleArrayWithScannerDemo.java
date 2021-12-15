package club.zhuangbinan.queue;

import java.util.Scanner;

public class CirCleArrayWithScannerDemo {

    public static void main(String[] args) {

        CircleArray que = new CircleArray(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = false;
        char key;

        while (!loop) {
            try {
                System.out.println("请按如下提示输入:");
                System.out.println("s(show): 显示队列");
                System.out.println("e(exit): 退出程序");
                System.out.println("a(add): 添加数据到队列");
                System.out.println("g(get): 从队列取出数据");
                System.out.println("h(head): 查看队列头的数据");
                key = scanner.next().charAt(0);//接收一个字符
                switch (key) {
                    case 's':
                        que.showCircleQueue();
                        break;
                    case 'e':
                        System.out.println("退出程序");
                        loop = true;
                        break;
                    case 'a':
                        System.out.println("请再输入一个数字:");
                        que.add(scanner.nextInt());
                        System.out.println("输入的数字被添加到队列中");
                        break;
                    case 'g':
                        System.out.println("取出的数字为:" + que.get());
                        break;
                    case 'h':
                        System.out.println("队列头数据:" + que.queryHead());
                        break;
                    default:
                        System.out.println("您的输入有误,请重新输入!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        scanner.close();

    }
}
