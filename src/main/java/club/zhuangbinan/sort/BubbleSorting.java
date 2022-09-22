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

        //适合betterBubbleSortPlus的array
        int[] arr51 = {1, 2, 3, 4, 5};
        int[] arr52 = {1, 2, 3, 4, 5};
        int[] arr53 = {1, 2, 3, 4, 5};
        normalBubbleSort(arr51,false);
        betterBubbleSort(arr52,false);
        betterBubbleSortPlus(arr53,false);

        //适合betterBubbleSortPlus的array2
        int[] arr6 = {1, 3, 2, 5, 4};
        int[] arr7 = {1, 3, 2, 5, 4};
        int[] arr8 = {1, 3, 2, 5, 4};

        normalBubbleSort(arr6,true);
        betterBubbleSort(arr7,true);
        betterBubbleSortPlus(arr8,true);

    }

    /**
     * normal bubble sort
     * @param arr array that you will sort
     * @param isShowProgress is show sorting progress
     */
    public static void normalBubbleSort(int[] arr, boolean isShowProgress) {
        int temp = Integer.MIN_VALUE;
        int sortCount = 0;
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
        int sortCount = 0;
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
        int sortCount = 0;
        int plusCount = 0;
        //内层for循环是一次冒泡排序的
        //还要在外层加一层for循环驱动内层排序直到排序完成
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) { // - j 很巧妙
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    plusCount ++; //交换次数
                }
                sortCount++; //判断元素的次数,内层for的次数
            }
            if (isShowProgress) {
                System.out.println(Arrays.toString(arr));
            }
            if (plusCount == 0) {
                System.out.printf("betterBubbleSortPlus排序结果:%s\n",Arrays.toString(arr));
                System.out.printf("betterBubbleSortPlus排序次数:%s\n",sortCount);
                return;
            }else {
                plusCount = 0; //修正判断条件
            }
        }
        System.out.printf("betterBubbleSortPlus排序结果:%s\n",Arrays.toString(arr));
        System.out.printf("betterBubbleSortPlus排序次数:%s\n",sortCount);
    }

}
