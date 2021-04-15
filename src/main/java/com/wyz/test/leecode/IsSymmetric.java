package com.wyz.test.leecode;

import com.wyz.test.TreeNode;
import com.wyz.test.Utils;

import java.util.TreeSet;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的
 */
public class IsSymmetric extends AbstractLeecode {
    @Override
    public void onRun() {
        Utils.println("" + test(node.left, node.right));
    }

    /**
     * 递归
     *
     * @param left
     * @param right
     * @return
     */
    private boolean test(TreeNode left, TreeNode right) {
        boolean isSame = false;
        if (left == null || right == null) return false;
        if (left.left != null && right.right != null) {
            isSame = test(left.left, right.right);
        } else isSame = left.left == null && right.right == null;

        if (left.right != null && right.left != null) {
            isSame = test(left.right, right.left);
        }else isSame = left.right == null && right.left == null;
        if (left.val == right.val) {
            isSame = true;
        }else{
            isSame = false;
        }

        return isSame;
    }

    private TreeNode node;

    /**
     * 遍历一遍就知道
     * 1
     * 2 2
     * 3 5 5 3
     */
    @Override
    public void before() {
        node = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(3, new TreeNode(4), new TreeNode(3)));
    }
}
