package com.wyz.test.sort;

import com.wyz.test.Utils;

import java.util.Random;

public class Fast {
    private static void fastTest() {
        final Integer[] array = new Integer[20];
        Random random = new Random();
        for (int idx = 0; idx < array.length; idx++) {
            array[idx] = random.nextInt(20);
        }
        Utils.printArray(array);
        fast(array, 0, array.length - 1);
        Utils.printArray(array);
    }

    /**
     * 快速排序
     *
     * @param array
     */
    private static void fast(final Integer[] array, int start, int end) {
        if (start > end) return;
        Utils.printArray(array, start, end);
        int realStart = start + 1;
        int realEnd = end;
        Utils.println("-> start %s , end %s  realStart %s  realEnd %s  标定值 %s ", start, end, realStart, realEnd, array[start]);
        while (realStart < realEnd) {
            Utils.println("start %s , end %s", realStart, realEnd);
            if (array[realStart] <= array[start]) {
                realStart++;
                continue;
            }
            if (array[realEnd] >= array[start]) {
                realEnd--;
                continue;
            }
            Integer temp = array[realStart];
            array[realStart] = array[realEnd];
            array[realEnd] = temp;
            Utils.printArray(array, start, end);
        }
        Utils.println("-> start %s , end %s  realStart %s  realEnd %s  标定值 %s  结束值 %s \n", start, end, realStart, realEnd, array[start], array[realStart]);
        if (array[realStart] < array[start]) {
            Integer temp = array[realStart];
            array[realStart] = array[start];
            array[start] = temp;
        } else {
            realStart--;
            Integer temp = array[realStart];
            array[realStart] = array[start];
            array[start] = temp;
        }

        fast(array, start, realStart - 1);
        fast(array, realStart + 1, end);
    }

}
