package com.wyz.test.leecode;

import com.wyz.test.Utils;

import java.util.Arrays;

/**
 * 26. 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates extends AbstractLeecode{
    @Override
    public void onRun() {
        // 双指针法
        // 1 , 1 , 1, 2  2  2  4, 5, 6, 7
        int left = 0 ;
        int right = 0 ;
        for ( ;right < nums.length ; right++){
            if(nums[left] != nums[right]){
                left++ ;
                nums[left] = nums[right] ;
            }
        }
        Utils.printIntArray(nums);
        Utils.println(" "+(left+1));
    }
    int[] nums ;
    @Override
    public void before() {
        nums = new int[]{1 , 1 , 2} ;
    }
}
