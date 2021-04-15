package com.wyz.test.leecode;

import com.wyz.test.ListNode;
import com.wyz.test.Utils;

/**
 * 92
 * 给你单链表的头指针 head 和两个整数 left 和 right ，
 * 其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseBetween2 extends ReverseBetween {
    /**
     * 反转链表指定的 开始和结尾
     * 和反转链表类似
     * 相同的都是 , 将起点节点 在新的链表进行头插入
     * 于此同时 , 遍历整个链表 , 当 开始 和 结尾 都进行标注好后 , 新的倒叙链表也完成
     * 此时进行头和尾的 替换即可
     */
    @Override
    public void onRun() {
        Utils.println(head.toString());
        Utils.println(test(head, 1, 2).toString());
    }

    private ListNode test(ListNode node, int left, int right) {
        Utils.println(" --- >");
        final ListNode result = new ListNode(-1, node);
        ListNode curr = result;
        int point = 0;
        ListNode startLeftFinal = null;
        ListNode endRightFinal = null;
        ListNode newNodeFinal = new ListNode(-1);
        ListNode newNodeEnd = newNodeFinal;
        if(left == 1){
            startLeftFinal = result ;
        }
        while (curr != null) {
            Utils.println(" --- >" + point);
            curr = curr.next;
            point++;
            if (point == left - 1) {
                startLeftFinal = curr;
            } else if (point >= left && point <= right) {
                if (point == right) {
                    endRightFinal = curr;
                }
                if(newNodeFinal.next == null){
                    newNodeEnd = new ListNode(curr.val);
                    newNodeFinal.next = newNodeEnd ;
                }else{
                    newNodeFinal.next = new ListNode(curr.val , newNodeFinal.next);
                }
                Utils.println("point >= left && point <= right -->" + newNodeFinal.toString());
            } else if (point > right) {
                if (endRightFinal != null && startLeftFinal != null) {
                    startLeftFinal.next = newNodeFinal.next ;
                    newNodeEnd.next = endRightFinal.next ;
                }
                break;
            }

        }
        return result.next;
    }

    /**
     * 用于提交 leecode
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 36.5 MB
     * , 在所有 Java 提交中击败了
     * 5.11%
     * 的用户
     * @param head
     * @param left
     * @param right
     * @return
     */
    private ListNode testCommit(ListNode head, int left, int right) {
        final ListNode result = new ListNode(-1, head);
        ListNode curr = result;
        int point = 0;
        ListNode startLeftFinal = null;
        ListNode endRightFinal = null;
        ListNode newNodeFinal = new ListNode(-1);
        ListNode newNodeEnd = newNodeFinal;
        if(left == 1){
            startLeftFinal = result ;
        }
        while (curr != null) {
            curr = curr.next;
            point++;
            if (point == left - 1) {
                startLeftFinal = curr;
            } else if (point >= left && point <= right) {
                if (point == right) {
                    endRightFinal = curr;
                }
                if(newNodeFinal.next == null){
                    newNodeEnd = new ListNode(curr.val);
                    newNodeFinal.next = newNodeEnd ;
                }else{
                    newNodeFinal.next = new ListNode(curr.val , newNodeFinal.next);
                }
            } else if (point > right) {
                if (endRightFinal != null && startLeftFinal != null) {
                    startLeftFinal.next = newNodeFinal.next ;
                    newNodeEnd.next = endRightFinal.next ;
                }
                break;
            }
        }
        return result.next;
    }

}
