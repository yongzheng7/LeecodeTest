package com.wyz.test.leecode;

import com.wyz.test.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum extends AbstractLeecode {

    /**
     * 三数之和
     * 需要拆分开来 变成一个数了剩下两个数的计算
     *
     * 四数只和 和三数只和类似 也是查分开
     */
    @Override
    public void onRun() {
        final List<List<Integer>> result = new ArrayList<>();
        Utils.printIntArray(value);
        Arrays.sort(value);
        Utils.printIntArray(value);
        for (int i = 0; i < value.length; i++) {
            if (value[i] > 0) break;
            if (i > 0 && value[i] == value[i - 1]) continue;
            int target = -value[i];
            int left = i + 1;
            int right = value.length - 1;
            while (left < right) {
                if (value[left] + value[right] == target) {
                    result.add(Arrays.asList( value[i], value[left], value[right]));
                    while (left < right && value[left] == value[left + 1]) left++;
                    while (left < right && value[right] == value[right - 1]) right--;
                    left++;
                    right--;
                }else if(value[left]+value[right] > target){
                    right-- ;
                }else {
                    left++ ;
                }
            }
        }
        Utils.println(result.toString());
    }

    int[] value;

    @Override
    public void before() {
        value = new int[]{-1, 0, 1, 2, -1, -4};
    }
}
