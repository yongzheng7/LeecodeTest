package com.wyz.test.leecode;

import com.wyz.test.ListNode;
import com.wyz.test.Utils;

/**
 * 21. 合并两个有序链表
 */
public class MergeTwoLists extends AbstractLeecode {
    @Override
    public void onRun() {
        Utils.println(test3(l1 , l2).toString());
    }

    private void test1() {
        final ListNode result = new ListNode(-1);
        ListNode curr = result;
        ListNode tempOne = l1;
        ListNode tempTwo = l2;
        while (tempOne != null || tempTwo != null) {
            if (tempOne != null && tempTwo != null) {
                ListNode listNode; // 都存在
                if (tempOne.val > tempTwo.val) { // 判断大小
                    curr.next = new ListNode(tempTwo.val); // 进行插入 并且再次进行下一个
                    curr = curr.next;
                    tempTwo = tempTwo.next;
                    continue;
                } else if (tempOne.val < tempTwo.val) {
                    curr.next = new ListNode(tempOne.val);
                    curr = curr.next;
                    tempOne = tempOne.next;
                    continue;
                } else {
                    // 数字相同
                    listNode = new ListNode(tempTwo.val, new ListNode(tempOne.val));
                    curr.next = listNode;
                    curr = listNode.next;
                }
            } else { // 有一个为null
                if (tempOne != null) curr.next = new ListNode(tempOne.val);
                if (tempTwo != null) curr.next = new ListNode(tempTwo.val);
                curr = curr.next;
            }
            tempOne = tempOne != null ? tempOne.next : null;
            tempTwo = tempTwo != null ? tempTwo.next : null;

        }
        Utils.println(result.next.toString());
    }

    private ListNode test2(ListNode tempOne , ListNode tempTwo) {
        final ListNode result = new ListNode(-1);
        ListNode curr = result;
        while (tempOne != null && tempTwo != null) {
            if (tempOne.val >= tempTwo.val) { // 判断大小
                curr.next = new ListNode(tempTwo.val); // 进行插入 并且再次进行下一个
                tempTwo = tempTwo.next;
            } else {
                curr.next = new ListNode(tempOne.val);
                tempOne = tempOne.next;
            }
            curr = curr.next;
        }
        if (tempOne != null) curr.next = tempOne;
        if (tempTwo != null) curr.next = tempTwo;
        Utils.println(result.next.toString());
        return result.next ;
    }
    //递归的思想

    /**
     * 传入两个 头节点
     *先判断是否weinull
     * 在判断大小 如果大小
     *
     */
    private ListNode test3(ListNode l1, ListNode l2) {
        ListNode newNode;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            if (l1.val > l2.val) {
                newNode = l2 ;
                newNode.next = test3(l1 , l2.next) ;
            }else{
                newNode = l1 ;
                newNode.next = test3(l1.next , l2) ;
            }
            return newNode;
        }
    }

    ListNode l1;
    ListNode l2;

    @Override
    public void before() {
        l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        l1 = new ListNode(5);
        l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    }
}
