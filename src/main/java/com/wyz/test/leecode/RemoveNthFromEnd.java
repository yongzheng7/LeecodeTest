package com.wyz.test.leecode;

import com.wyz.test.ListNode;
import com.wyz.test.Utils;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd extends AbstractLeecode {


    @Override
    public void onRun() {
        Utils.println(head.toString());
        ListNode result = new ListNode(-1, head); // 包装一下 以便进行最后输出 , 预防给的只有了个并且只删除一个
        ListNode curr = result; // 判断链表是否完成遍历
        ListNode leftNode = result; // 进行定位待删除的节点
        int left = -1; // 初始左指针
        int right = -1; // 初始右指针

        while (curr != null) {
            curr = curr.next; // 进行循环
            if (curr == null) { // 判断是否循环完成
                if (leftNode != null) { // 循环完成进行删除
                    ListNode next = leftNode.next;
                    if (next != null) {
                        leftNode.next = next.next;
                    }
                }
            } else {
                if (right - left == n) { // 进行判读是否左指针能够进行位移
                    left++;
                    leftNode = leftNode.next;
                }
                right++;
            }
        }
        Utils.println((result.next != null ? result.next.toString() : "[]"));
    }

    ListNode head;
    int n;

    @Override
    public void before() {
        //head = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8)))))));
        head = new ListNode(2);
        n = 1;
    }
}
