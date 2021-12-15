package club.zhuangbinan.queue;

/**
 * 数组模拟队列 demo
 * 缺点, 数组使用一次, 就不能用了,没有达到复用的效果;
 * @author zhuangbinan 12/14/2021
 */
public class ArrayQueueTest {

    private int arr[];
    private int maxSize;
    private int rear;
    private int front;

    public ArrayQueueTest(int maxSize) {
        this.maxSize = maxSize;
        this.rear = -1;
        this.front = -1;
        this.arr = new int[this.maxSize];
    }

    private boolean isFull() {
        return rear == maxSize - 1;
    }

    private boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("数组模拟的队列已满,无法添加");
            return;
        }
        rear++;
        this.arr[rear] = n; //这种写法比下面2行注释的要更好
//        this.arr[rear + 1] = n;
//        rear++;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("数组模拟的队列已经是空的,无法再取");
        }
        int headNum = getHeadQueue();
        front++;
        this.arr[front] = 0;
        return headNum;
    }

    public int getHeadQueue() {
        if (isEmpty()) {
            throw new RuntimeException("数组模拟的队列已经是空的,无法再取");
        }
        return this.arr[front + 1];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的哦~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

//    public static void main(String[] args) {
//
//        try {
//            ArrayQueueTest queue = new ArrayQueueTest(3);
//            queue.addQueue(1);
//            queue.addQueue(2);
//            queue.addQueue(3);
//            queue.getHeadQueue();
//            queue.getQueue();
//            queue.getQueue();
//            queue.getQueue();
//            queue.getQueue();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        try {
//            ArrayQueueTest queue2 = new ArrayQueueTest(3);
//            queue2.getQueue();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }


}

