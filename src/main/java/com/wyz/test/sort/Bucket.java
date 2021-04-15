package com.wyz.test.sort;

import com.wyz.test.Utils;

import java.util.Arrays;
import java.util.Random;

public class Bucket {


    public static void bucketTest() {
        final Integer[] array = new Integer[10];
        Random random = new Random();
        for (int idx = 0; idx < array.length; idx++) {
            array[idx] = random.nextInt(10);
        }
        Utils.printArray(array);
        bucket(array);
        Arrays.sort(array);
        Utils.printArray(array);
    }

    /**
     * 桶排序
     *
     * @param ass
     * @return
     */
    public static void bucket(Integer[] ass) {
        // 开辟一个数组 也可以开辟一个链表
        int[] temp = new int[ass.length];
        for (Integer item : ass
        ) {
            temp[item]++;
        }

        for (int idx = 0; idx < temp.length; idx++) {
            if (temp[idx] == 0) continue;
            for (int idy = 0; idy < temp[idx]; idy++) {
                Utils.print(idx + " , ");
            }
        }
    }
}
