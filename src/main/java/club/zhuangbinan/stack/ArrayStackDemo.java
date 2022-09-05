package club.zhuangbinan.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.showStackDesc();
//        arrayStack.showStackASC();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(6);
        arrayStack.push(6);
        arrayStack.showStackDesc();
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println("1111111111111");
        arrayStack.showStackDesc();
        System.out.println(arrayStack.pop());
    }
}


class ArrayStack {

    private int maxSize; //栈的最大值
    private int[] stack; //数组作为容器
    private int top = -1; //指针, 当 top = maxSize - 1 为栈满

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 先进先出的顺序 展示
     */
    public void showStackDesc() {
        if (this.stack != null && this.stack.length > 0) {
            for (int i = stack.length - 1; i > -1; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    /**
     * 从栈底到栈顶的顺序 展示
     */
    public void showStackASC() {
        if (this.stack != null && this.stack.length > 0) {
            for (int i = 0; i < stack.length; i++) {
                System.out.println(stack[i]);
            }
        }
    }

    /**
     * 压栈
     * @param i int
     */
    public void push(int i){
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        stack[++top] = i;
    }

    /**
     * 弹栈
     *
     */
    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("栈已空");
        }
        int temp = top--;
        int result = stack[temp];
        stack[temp] = 0;
        return result;
    }

}
