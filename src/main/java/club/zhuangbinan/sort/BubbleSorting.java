package club.zhuangbinan.sort;

import java.util.Arrays;

/**
 * BubbleSorting by myself
 */
public class BubbleSorting {

    public static void main(String[] args) {
        int[] arr1 = {-1, 2, 10, 9, -2};
        int[] arr2 = {-1, 2, 10, 9, -2};
        int[] arr3 = {-1, 2, 10, 9, -2};


        //双重for循环版本 O(n²)
        normalBubbleSort(arr1,true);
        betterBubbleSort(arr2,true);
        betterBubbleSortPlus(arr3,true);

        System.out.println("=================================================================");
        //适合betterBubbleSortPlus的array
        int[] arr51 = {1, 2, 3, 4, 5};
        int[] arr52 = {1, 2, 3, 4, 5};
        int[] arr53 = {1, 2, 3, 4, 5};
        normalBubbleSort(arr51,false);
        betterBubbleSort(arr52,false);
        betterBubbleSortPlus(arr53,false);
        System.out.println("=================================================================");
        //适合betterBubbleSortPlus的array2
        int[] arr6 = {1, 3, 2, 5, 4};
        int[] arr7 = {1, 3, 2, 5, 4};
        int[] arr8 = {1, 3, 2, 5, 4};

        normalBubbleSort(arr6,true);
        betterBubbleSort(arr7,true);
        betterBubbleSortPlus(arr8,true);
        System.out.println("=================================================================");

        //测试冒泡排序的速度O(n^2)
        int[] arr8W = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr8W[i] = (int)(Math.random() * 800000);
        }

        int[] arr8W_1 = new int[80000];
        int[] arr8W_2 = new int[80000];
        for (int i = 0; i < arr8W.length; i++) {
            arr8W_1[i] = arr8W[i];
            arr8W_2[i] = arr8W[i];
        }

        long startMill = System.currentTimeMillis();
        normalBubbleSort(arr8W,false);
        long endMill = System.currentTimeMillis();

        long startMill1 = System.currentTimeMillis();
        betterBubbleSort(arr8W_1,false);
        long endMill1 = System.currentTimeMillis();

        long startMill2 = System.currentTimeMillis();
        betterBubbleSortPlus(arr8W_2,false);
        long endMill2 = System.currentTimeMillis();

        System.out.printf("normalBubbleSort cost time %s ms\n",endMill-startMill); //normalBubbleSort cost time 8880 ms ; normalBubbleSort排序次数:6399840001
        System.out.printf("betterBubbleSort cost time %s ms\n",endMill1-startMill1); //betterBubbleSort cost time 7032 ms; betterBubbleSort排序次数:3199960000
        System.out.printf("betterBubbleSortPlus cost time %s ms\n",endMill2-startMill2); //betterBubbleSortPlus cost time 7673 ms ; betterBubbleSortPlus排序次数:3199953445
        System.out.println("=================================================================");


    }

    /**
     * normal bubble sort
     * @param arr array that you will sort
     * @param isShowProgress is show sorting progress
     */
    public static void normalBubbleSort(int[] arr, boolean isShowProgress) {
        int temp = Integer.MIN_VALUE;
        long sortCount = 0;
        //内层for循环是一次冒泡排序的
        //还要在外层加一层for循环驱动内层排序直到排序完成
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
                sortCount++;
            }
            if (isShowProgress) {
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.printf("normalBubbleSort排序结果:%s\n",Arrays.toString(arr));
        System.out.printf("normalBubbleSort排序次数:%s\n",sortCount);
    }

    /**
     * better bubble sort
     * @param arr array that you will sort
     * @param isShowProgress is show sorting progress
     */
    public static void betterBubbleSort(int[] arr, boolean isShowProgress) {
        int temp = Integer.MIN_VALUE;
        long sortCount = 0;
        //内层for循环是一次冒泡排序的
        //还要在外层加一层for循环驱动内层排序直到排序完成
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) { // - j 很巧妙
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
                sortCount++;
            }
            if (isShowProgress) {
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.printf("betterBubbleSort排序结果:%s\n",Arrays.toString(arr));
        System.out.printf("betterBubbleSort排序次数:%s\n",sortCount);
    }

    //优化思路 如果在某趟排序中,没有发生一次交换,则可以提前结束 bubble sorting
    /**
     * better bubble sort plus
     * @param arr array that you will sort
     * @param isShowProgress is show sorting progress
     */
    public static void betterBubbleSortPlus(int[] arr, boolean isShowProgress) {
        int temp = Integer.MIN_VALUE;
        long sortCount = 0;
//        int plusCount = 0;
        boolean flag = false;
        //内层for循环是一次冒泡排序的
        //还要在外层加一层for循环驱动内层排序直到排序完成
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) { // - j 很巧妙
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
//                    plusCount ++; //交换次数
                    flag = true;
                }
                sortCount++; //判断元素的次数,内层for的次数
            }
            if (isShowProgress) {
                System.out.println(Arrays.toString(arr));
            }
            if (!flag) {
                System.out.printf("betterBubbleSortPlus排序结果:%s\n", Arrays.toString(arr));
                System.out.printf("betterBubbleSortPlus排序次数:%s\n", sortCount);
                return;
            }else{
                flag = false;
            }
//            if (plusCount == 0) {
//                System.out.printf("betterBubbleSortPlus排序结果:%s\n",Arrays.toString(arr));
//                System.out.printf("betterBubbleSortPlus排序次数:%s\n",sortCount);
//                return;
//            }else {
//                plusCount = 0; //修正判断条件
//            }
        }
        System.out.printf("betterBubbleSortPlus排序结果:%s\n",Arrays.toString(arr));
        System.out.printf("betterBubbleSortPlus排序次数:%s\n",sortCount);
    }

}
