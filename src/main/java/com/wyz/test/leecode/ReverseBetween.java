package com.wyz.test.leecode;

import com.wyz.test.ListNode;
import com.wyz.test.Utils;

/**
 * 92. 反转链表 II
 * 206. 反转链表
 * 反转链表 将一个链表进行反转
 *
 */
public class ReverseBetween extends AbstractLeecode {

    @Override
    public void onRun() {
        test2() ;
    }

    private void test1() {
        Utils.println(head.toString());
        // 1 2 3 4
        // 4 3 2 1  可以使用栈
        ListNode[] array = new ListNode[5];
        ListNode curr = head;
        int idx = 0;
        while (curr != null) {
            array[idx++] = curr;
            curr = curr.next;
        }
        ListNode result = new ListNode(-1);
        ListNode node = result;
        for (int j = idx - 1; j >= 0; j--) {
            if (array[j] == null) break;
            array[j].next = null;
            node.next = array[j];
            node = node.next;
        }
        Utils.println(result.next.toString());
    }

    private void test2() {
        // 反转一个链表
        // 1 -> 2 -> 3 -> 4
        // 1 <- 2 <- 3 <- 4
        // left  right
        Utils.println(head.toString());
        ListNode result = new ListNode(-1);
        ListNode currHead = head;
        ListNode currResult = result;
        while (currHead != null) {
            ListNode next = currHead.next;
            currHead.next = null;
            if(currResult.next == null){
                currResult.next = currHead;
            }else{
                ListNode next1 = currResult.next;
                currResult.next = currHead;
                currResult.next.next = next1 ;
            }
            currHead = next;
        }
        Utils.println(result.next.toString());
    }

    // 使用递归
    protected ListNode head;

    @Override
    public void before() {
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4 ,  new ListNode(5 ,  new ListNode(6 ,  new ListNode(7 ,  new ListNode(8 , new ListNode(9,  new ListNode(10))))))))));
        //head = new ListNode(1, new ListNode(2));
    }
}
