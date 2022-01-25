package club.zhuangbinan.queue;

/**
 * 数组模拟环形队列demo
 * 是 ArrayQueueTest 的改进版
 */
public class CircleArray {

    private int[] arr;
    private int maxSize;
    // front 和 rear 在环形数组中初始值为0
    private int front;
    private int rear;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    private boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    private boolean isEmpty() {
        return rear == front;
    }

    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    public void add(int n) {
        if (isFull()) {
            System.out.println("环形数组已满,无法加入");
            return;
        }
        this.arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 拿出一个
     * @return 队列的第一个
     */
    public int get(){
        if (isEmpty()) {
            throw new RuntimeException("数组模拟的环形队列已经是空的,无法再取");
        }
        int result = this.arr[front];
        front = (front + 1) % maxSize;
        return result;
    }

    public int queryHead(){
        if (isEmpty()) {
            throw new RuntimeException("数组模拟的环形队列是空的");
        }
        return arr[front];
    }

    public void showCircleQueue(){
        if (isEmpty()) {
            System.out.println("当前环形队列为空");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize , arr[i % maxSize]);
        }
    }

}
