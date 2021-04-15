package com.wyz.test.leecode;

import com.wyz.test.ListNode;
import com.wyz.test.Utils;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs extends AbstractLeecode {
    /**
     * - 1 2 3 4 5 6 7 8 9
     * 2 1 3 4 5 6 8 7 9
     */
    @Override
    public void onRun() {
        Utils.println( swap(head).toString());
    }

    private ListNode swap(ListNode listNodes) {
        // 思路一 循环遍历 每次循环两个
        // -1  1  2  3
        ListNode result = new ListNode(-1, listNodes); // 主要是将头节点保存起来
        ListNode curr = result;
        int point = 0;
        while (curr != null) {
            if (point % 2 == 0) {
                ListNode a1 = curr.next;
                if(a1 != null){
                    ListNode a2 = a1.next;
                    if(a2 != null){
                        a1.next = a2.next;
                        curr.next = a2 ;
                        a2.next = a1 ;
                    }
                }
            }
            point++;
            curr = curr.next;
        }
        return result.next ;
    }

    ListNode head;

    @Override
    public void before() {
        head = new ListNode(1, new ListNode(2, new ListNode(4 , new ListNode(5 ))));
        head = new ListNode(1, new ListNode(2, new ListNode(4 )));
    }
}
