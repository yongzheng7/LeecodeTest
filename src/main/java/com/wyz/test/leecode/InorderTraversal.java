package com.wyz.test.leecode;

import com.wyz.test.TreeNode;
import com.wyz.test.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * 递归
 * 迭代
 */
public class InorderTraversal extends AbstractLeecode {

    @Override
    public void onRun() {
        Utils.printTree(node);
        Utils.printList(test(node));
    }
    // 迭代
    // 找出最小的数
    private List<Integer> test(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>() ;
        TreeNode root  = node ;
        final ArrayList<Integer> result = new ArrayList<>() ;
        while (stack.size() > 0 || root != null){
            if(root!= null){
                stack.add(root);
                root = root.left ;
            }else{
                TreeNode tmp = stack.pop();
                result.add(tmp.val);
                root = tmp.right;
            }
        }
        return result;
    }


    // 递归
    /**
     * 找出最小的树使用 栈
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 36.9 MB
     * , 在所有 Java 提交中击败了
     * 20.11%
     * 的用户
     * @param root
     * @return
     */
    private List<Integer> test2(TreeNode root) {
        final ArrayList<Integer> result = new ArrayList<>() ;
        if(root == null) return result ;
        if(root.left != null){
            result.addAll(test2(root.left));
        }
        result.add(root.val);
        if(root.right != null){
            result.addAll(test2(root.right));
        }
        return result;
    }

    private TreeNode node;

    @Override
    public void before() {
        node = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    }
}
