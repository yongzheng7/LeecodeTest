package com.wyz.test.leecode;

import com.wyz.test.Utils;

public class lengthOfLongestSubstring extends AbstractLeecode {

    /**
     * 思路
     * 1 创建一个栈类型数据结构
     * 2 每次将数据入栈时 ,检查栈内是否有相同元素 , 如果没有 那么 入栈指针上移
     * 3 如果存在相同元素, 情况栈,初始化指针,重新入栈
     * 4 最后每次入栈和 存储的最大栈数作比较, 得到最大的一个栈数据
     *
     * 时间复杂度 n * 26
     */
    @Override
    public void onRun() {
        int left = 0;
        int right = -1;
        int size = 0;
        char temp  ;
        if(s.length() != 0 ){
            for (int point = 0 ; point < s.length() ; point++){
                temp = s.charAt(point);
                for (int idx = left; idx <= right; idx++) { // 最坏的结果就是 给定的数组就是最大的不重复数组 26次
                    if (s.charAt(idx) == temp) {
                        left = idx+1 ;
                        break;
                    }
                }
                ++right;
                if (right-left > size) {
                    size = right-left;
                }
            }
            Utils.println("%d" , size+1);
        }

    }

    String s;
     // abcaeffabc
    @Override
    public void before() {
        s = "01234467891";
    }
}
