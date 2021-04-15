package com.wyz.test.leecode;

import com.wyz.test.Utils;

public class IsPalindrome extends AbstractLeecode {

    int x;

    @Override
    public void onRun() {
        //test1();
        test2();
    }

    public void test1() {
        final String aa = String.valueOf(x);
        Utils.println(aa);
        int left = 0;
        int right = aa.length() - 1;
        boolean isTrue = true;
        while (left < right) {
            if (aa.charAt(left) != aa.charAt(right)) {
                isTrue = false;
            }
            left++;
            right--;
        }
        Utils.println("" + isTrue);
    }

    public void test2() {
        if (x < 0) {
            Utils.println("false");
        }
        boolean isTrue = true;
        int maxInt = 1;
        int max = 1;
        while (x / maxInt > 10) {
            maxInt *= 10;
            max++;
        }
        Utils.println("%d , %d ", maxInt, max);
        int tempValue = x;
        while (tempValue != 0) {
            int currC = tempValue / maxInt;
            tempValue = tempValue % maxInt;
            maxInt /= 10;

        }
    }

    @Override
    public void before() {
        x = 121;
    }
}
