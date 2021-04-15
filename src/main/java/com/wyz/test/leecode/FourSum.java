package com.wyz.test.leecode;

import com.wyz.test.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum extends AbstractLeecode {

    /**
     * 四数只和 是三数之和的变种 归根还是 要分为 双数之和
     */
    @Override
    public void onRun() {
        final int sum = 0 ;
        final List<List<Integer>> result = new ArrayList<>();
        Utils.printIntArray(value);
        Arrays.sort(value);
        Utils.printIntArray(value);
        for (int j = 0; j < value.length; j++){
            if (value[j] > 0) break;
            if (j > 0 && value[j] == value[j - 1]) continue;
            int target = sum-value[j];
            for (int i = j+1; i < value.length; i++) {
                if (i > j+1 && value[i] == value[i - 1]) continue;
                int target2 = target - value[i];
                int left = j + 2;
                int right = value.length - 1;
                while (left < right) {
                    if (value[left] + value[right] == target2) {
                        result.add(Arrays.asList(value[j] ,value[i], value[left], value[right]));
                        while (left < right && value[left] == value[left + 1]) left++;
                        while (left < right && value[right] == value[right - 1]) right--;
                        left++;
                        right--;
                    }else if(value[left]+value[right] > target2){
                        right-- ;
                    }else {
                        left++ ;
                    }
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
