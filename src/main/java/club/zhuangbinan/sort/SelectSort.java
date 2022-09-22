package club.zhuangbinan.sort;

import java.util.Arrays;

/**
 * Select Sort
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};

        Arrays.parallelSort(arr);
        System.out.println(Arrays.toString(arr
        ));

    }


}
