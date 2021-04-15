package com.wyz.test.sort;

import com.wyz.test.Utils;

import java.util.Random;

public class Bubbling {

    private static void BubblingTest() {
        final Integer[] array = new Integer[100];
        Random random = new Random();
        for (int idx = 0; idx < array.length; idx++) {
            array[idx] = random.nextInt(100);
        }
        Utils.printArray(array);
        Bubbling(array);
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    private static void Bubbling(final Integer[] array) {
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    Integer temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                size++;
            }
            Utils.printArray(array);
        }
        Utils.printArray(array);
        Utils.println("" + size);
    }
}
