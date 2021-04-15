package com.wyz.test.leecode;

import com.wyz.test.Utils;

/**
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOne extends AbstractLeecode {
    @Override
    public void onRun() {
        Utils.printIntArray(test3());
    }

    /**
     * 拓展一下
     * 1 每位都加 1
     * 2 偶数位加 1
     * 3 每位都减 1
     * 4 减1
     *
     * @return
     */

    public int[] test() {
        int n = digits.length;
        for (int idx = n - 1; idx >= 0; idx--) {
            if (digits[idx] < 9) {
                digits[idx]++;
                return digits;
            }
            digits[idx] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

    /**
     * 1 每位都加 1
     *
     * @return
     */
    public int[] test2() {
        int temp = 0;
        int n = digits.length;
        for (int idx = n - 1; idx >= 0; idx--) {
            digits[idx] = digits[idx] + 1 + temp; // 先进行计算 得到计算后的数
            if (digits[idx] > 9) { // 判断是否需要进位
                temp = digits[idx] / 10; // 得到进位并设置自己的数为 取余后的值 前后顺序不可颠倒
                digits[idx] = digits[idx] % 10;
            } else {
                temp = 0;
            }
        }
        if (temp > 0) { //判断最高位也需要进位 , 进行扩容操作
            int[] res = new int[n + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        } else {
            return digits;
        }
    }

    /**
     * 1 偶数位加 1
     *
     * @return
     */
    public int[] test3() {
        int temp = 0;
        int n = digits.length;
        for (int idx = n - 1; idx >= 0; idx--) {
            if (idx % 2 != 0) {
                digits[idx] = digits[idx] + 1 + temp; // 先进行计算 得到计算后的数
            } else {
                digits[idx] = digits[idx] + temp; // 先进行计算 得到计算后的数
            }
            if (digits[idx] > 9) { // 判断是否需要进位
                temp = digits[idx] / 10; // 得到进位并设置自己的数为 取余后的值 前后顺序不可颠倒
                digits[idx] = digits[idx] % 10;
            } else {
                temp = 0;
            }
        }
        if (temp > 0) { //判断最高位也需要进位 , 进行扩容操作
            int[] res = new int[n + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        } else {
            return digits;
        }
    }


    /**
     * 减去1
     *
     * @return
     */
    public int[] test5() {
        int temp = 0;
        int n = digits.length;
        // 1 0 0 0 -> 9 9 9
        // 2 0 0 0 -> 1 9 9 9
        // 1 0 1 0 -> 1 0 0 9
        for (int idx = n - 1; idx >= 0; idx--) {
            if (digits[idx] == 0) {
                digits[idx] = 9;
            } else {
                digits[idx]--;
                break;
            }
        }
        if (digits[0] == 0) {
            int[] result = new int[digits.length - 1];
            System.arraycopy(digits, 1, result, 0, result.length);
            return result;
        }
        return digits;
    }

    int[] digits;

    @Override
    public void before() {
        digits = new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9};
        // 每位都加1
        digits = new int[]{9, 7, 9};
        // 偶数位加1
        digits = new int[]{1, 9, 7, 9};
        // 减1 从低位进行
        digits = new int[]{1, 0, 0, 0};

        digits = new int[]{2, 0, 0, 0};

        digits = new int[]{2, 0, 1, 0};
        // 减1 每位都减去1
        digits = new int[]{1, 0, 0, 0};

        digits = new int[]{1, 0, 1, 0};
    }
}
