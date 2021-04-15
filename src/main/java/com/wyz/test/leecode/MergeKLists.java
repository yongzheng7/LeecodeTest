package com.wyz.test.leecode;

import com.wyz.test.ListNode;
import com.wyz.test.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 */
public class MergeKLists extends AbstractLeecode{

    @Override
    public void onRun() {
        ListNode[] listNodes = list.toArray(new ListNode[0]);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val-b.val);
        for(ListNode node: listNodes) {
            if(null != node) {
                pq.add(node);
            }
        }
        ListNode result = null, cur = null;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            if(null == result) {
                result = cur = node;
            } else {
                cur = cur.next = node;
            }
            if(null != node.next) {
                pq.add(node.next);
            }
        }
        assert result != null;
        Utils.println(result.toString());
    }

    /**
     * 通过 一个一个合并
     */
    private void testMergeKLists1 (){
        ListNode[] listNodes = list.toArray(new ListNode[0]);
        ListNode listNode = listNodes[0] ;
        for (int j = 1 ; j < listNodes.length ; j++){
            listNode = test2(listNode , listNodes[j]);
        }
        Utils.println(listNode.toString());
    }

    /**
     * 通过多个过个合并
     */
    private void testMergeKLists2 (){
        ListNode listNode = listMarge(list.toArray(new ListNode[0]));
        assert listNode != null;
        Utils.println(listNode.toString());
    }

    List<ListNode> list ;
    @Override
    public void before() {
        list = new ArrayList<>() ;
        list.add(new ListNode(1, new ListNode(2, new ListNode(4)))) ;
        list.add(new ListNode(1, new ListNode(3, new ListNode(4)))) ;
        list.add(new ListNode(1, new ListNode(5, new ListNode(50)))) ;
        list.add(new ListNode(1, new ListNode(100, new ListNode(101)))) ;
        list.add(new ListNode(-1, new ListNode(99, new ListNode(101)))) ;
    }

    private ListNode listMarge(ListNode[]  listNodes){ // 重要的思想就是 打散分开 ,递归
        if(listNodes.length == 0)
            return null;
        if(listNodes.length == 1)
            return listNodes[0];
        if(listNodes.length == 2){
            return test2(listNodes[0],listNodes[1]);
        }

        int mid = listNodes.length/2 ;
        ListNode[] one = new ListNode[mid] ;
        for(int i = 0 ; i < one.length ; i++){
            one[i] = listNodes[i] ;
        }
        ListNode[] two = new ListNode[listNodes.length - mid] ;
        for(int j = 0 ; j < two.length ; j++){
            two[j] = listNodes[j+ mid] ;
        }
        return test2(listMarge(one) , listMarge(two)) ;
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
        return result.next ;
    }

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
}
