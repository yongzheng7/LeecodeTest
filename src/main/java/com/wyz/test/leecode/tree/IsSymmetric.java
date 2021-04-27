package com.wyz.test.leecode.tree;

import com.wyz.test.TreeNode;
import com.wyz.test.Utils;
import com.wyz.test.leecode.AbstractLeecode;

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
        boolean isSame = false; // 判断是否相同标识
        if (left == null || right == null) return false; // 判断两个是否weinull

        if (left.left != null && right.right != null) {
            // 判断左树的 左枝 和 右树的 右枝 是否为 null
            isSame = test(left.left, right.right);
        } else {
            // 如果树为null , 则判断是否都为null
            isSame = left.left == null && right.right == null;
        }
        // 判断左树的 右枝  和 右树的 左枝
        if (left.right != null && right.left != null) {
            isSame = test(left.right, right.left);
        }else {
            isSame = left.right == null && right.left == null;
        }
        // 最后判断数的值是否相同
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
