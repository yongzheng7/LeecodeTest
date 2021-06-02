package com.wyz.test.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * 找到所有出现两次的元素。
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * 示例：
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [2,3]
 */
public class CLeecode442 extends AbstractLeecode {
    @Override
    public void onRun() {
        final List<Integer> aa = new ArrayList<>() ;
        for (int idx = 0 ; idx < array.length ; idx++){
            // 获取对应的下标的值
            int a = array[idx];
            int b = Math.abs(a) ;
            int c = array[b-1];
            if(c > 0){
                array[b-1] = c * -1 ;
            }else{
                aa.add(b);
            }
        }
        for (Integer a:aa
             ) {
            System.out.print("  "+a);
        }
    }
    final int[] array = {4,3,2,7,8,2,3,1} ;
    @Override
    public void before() {

    }
}
