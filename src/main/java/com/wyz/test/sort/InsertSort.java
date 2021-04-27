package com.wyz.test.sort;

import com.wyz.test.Check;
import com.wyz.test.Utils;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {
    /**
     * 插入排序
     */
    private static void insertTest() {
        final Integer[] array = new Integer[20];
        Random random = new Random();
        for (int idx = 0; idx < array.length; idx++) {
            array[idx] = random.nextInt(20);
        }
        Utils.printArray(array);
        Integer[] clone = array.clone();
        insert(clone);
        Utils.printArray(clone);
        Arrays.sort(array);
        boolean b = Check.checkArray(array, clone);
        Utils.println("检查结果 : " + b);
    }

    private static void insert(final Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    Integer temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
