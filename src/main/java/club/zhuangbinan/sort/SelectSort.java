package club.zhuangbinan.sort;

import java.util.Arrays;

/**
 * Select Sort
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr1 = {101, 34, 119, 1};
        /*
         * 选择排序推导过程
        int[] arr = {101, 119, 34, 1};


        int tempIdx = 0;
        int tempVal = arr[0];
        for (int i = 0 + 1; i < arr.length; i++) {
            if (arr[i] < tempVal) {
                tempVal = arr[i];
                tempIdx = i;
            }
        }
        //交换
        if (tempIdx != 0) {
            arr[tempIdx] = arr[0];
            arr[0] = tempVal;
        }
        System.out.println(Arrays.toString(arr)); //[1, 34, 119, 101]  // [1, 119, 34, 101]


        tempIdx = 1;
        tempVal = arr[1];
        for (int i = 1 + 1; i < arr.length; i++) {
            if (arr[i] < tempVal) {
                tempVal = arr[i];
                tempIdx = i;
            }
        }
        //交换
        if (tempIdx != 1) {
            arr[tempIdx] = arr[1];
            arr[1] = tempVal;
        }
        System.out.println(Arrays.toString(arr)); //[1, 34, 119, 101]


        tempIdx = 2;
        tempVal = arr[2];
        for (int i = 2 + 1; i < arr.length; i++) {
            if (arr[i] < tempVal) {
                tempVal = arr[i];
                tempIdx = i;
            }
        }
        //交换
        if (tempIdx != 2) {
            arr[tempIdx] = arr[2];
            arr[2] = tempVal;
        }
        System.out.println(Arrays.toString(arr));

        */


//        selectSort(arr1);
        BubbleSorting.betterBubbleSort(arr1,false);
        System.out.println(Arrays.toString(arr1));

        //测速
        int[] arr8W = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr8W[i] = (int)(Math.random() * 800000);
        }

        int[] arr8W_1 = new int[80000];
        int[] arr8W_2 = new int[80000];
        int[] arr8W_3 = new int[80000];
        int[] arraysApi = new int[80000];
        for (int i = 0; i < arr8W.length; i++) {
            arr8W_1[i] = arr8W[i];
            arr8W_2[i] = arr8W[i];
            arr8W_3[i] = arr8W[i];
            arraysApi[i] = arr8W[i];
        }

        long startMill1 = System.currentTimeMillis();
        BubbleSorting.betterBubbleSort(arr8W,false);
        long endMill1 = System.currentTimeMillis();

        long startMill2 = System.currentTimeMillis();
        BubbleSorting.betterBubbleSortPlus(arr8W_1,false);
        long endMill2 = System.currentTimeMillis();

        long startMill3 = System.currentTimeMillis();
        selectSort(arr8W_2);
        long endMill3 = System.currentTimeMillis();

        long startMill4 = System.currentTimeMillis();
        Arrays.sort(arraysApi);
        long endMill4 = System.currentTimeMillis();

        long startMill5 = System.currentTimeMillis();
        BubbleSorting.normalBubbleSort(arr8W_3,false);
        long endMill5 = System.currentTimeMillis();

        //7358
        //8295
        //1134 选择排序 因为交换次数少, 所以比冒泡排序效率高
        //5
        //9159 普通冒泡
        System.out.println(endMill1 - startMill1);
        System.out.println(endMill2 - startMill2);
        System.out.println(endMill3 - startMill3);
        System.out.println(endMill4 - startMill4);
        System.out.println(endMill5 - startMill5);

    }

    public static void selectSort(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) { // 只需要数组长度-1次
            int tempIdx = j;
            int tempVal = arr[j];
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] < tempVal) {
                    tempVal = arr[i];
                    tempIdx = i;
                }
            }
            //交换
            if (tempIdx != j) {
                arr[tempIdx] = arr[j];
                arr[j] = tempVal;
            }
        }
    }

}
