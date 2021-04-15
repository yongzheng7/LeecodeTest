package com.wyz.test.sort;

import com.wyz.test.Check;
import com.wyz.test.Utils;

import java.util.Arrays;
import java.util.Random;

public class SelectSort {
    private static void selectTest() {
        final Integer[] array = new Integer[20];
        Random random = new Random();
        for (int idx = 0; idx < array.length; idx++) {
            array[idx] = random.nextInt(20);
        }
        Utils.printArray(array);
        Integer[] clone = array.clone();
        select(clone);
        Utils.printArray(clone);
        Arrays.sort(array);
        boolean b = Check.checkArray(array, clone);
        Utils.println("检查结果 : " + b);
    }

    private static void select(final Integer[] array) {
        for (int x = 0; x < array.length; x++) {
            int minValue = array[x];
            int minIdx = x;
            for (int j = x + 1; j < array.length; j++) {
                if (array[j] < minValue) {
                    minValue = array[j];
                    minIdx = j;
                }
            }
            if (minIdx != x) {
                int temp = array[x];
                array[x] = array[minIdx];
                array[minIdx] = temp;
            }
        }
    }
}
