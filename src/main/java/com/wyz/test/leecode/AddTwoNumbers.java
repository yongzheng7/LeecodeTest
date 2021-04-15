package com.wyz.test.leecode;

import com.wyz.test.ListNode;
import com.wyz.test.Utils;

public class AddTwoNumbers extends AbstractLeecode {

    // 我的思路是 设置一个进位
    @Override
    public void onRun() {
        int temp = 0;
        ListNode result = new ListNode(0); // 最后输出
        ListNode point = result; // 指针1 指向最后一位的next
        ListNode oneTemp = one;
        ListNode twoTemp = two;
        while (oneTemp != null || twoTemp != null || temp != 0) {
            int oneInt = oneTemp != null ? oneTemp.val : 0;
            int twoInt = twoTemp != null ? twoTemp.val : 0;

            final int curr = oneInt + twoInt + temp;
            temp = curr / 10;

            point.next = new ListNode(curr % 10);
            point = point.next;

            oneTemp = oneTemp != null ? oneTemp.next : null;
            twoTemp = twoTemp != null ? twoTemp.next : null;
        }
        Utils.println(result.next.toString());
    }

    public ListNode one;
    public ListNode two;

    @Override
    public void before() {
        one = new ListNode(2, new ListNode(4, new ListNode(3)));
        two = new ListNode(5, new ListNode(6, new ListNode(6 )));
        Utils.println(one.toString());
        Utils.println(two.toString());
    }
}
