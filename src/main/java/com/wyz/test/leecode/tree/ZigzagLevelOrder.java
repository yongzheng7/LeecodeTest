package com.wyz.test.leecode.tree;

import com.wyz.test.TreeNode;
import com.wyz.test.Utils;
import com.wyz.test.leecode.AbstractLeecode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class ZigzagLevelOrder extends AbstractLeecode {
    @Override
    public void onRun() {
        List<List<Integer>> lists = levelOrder(start);
        for (List<Integer> aa : lists
        ) {
            Utils.printList(aa);
        }
    }
    /**
     * 是二叉树的层序遍历 的变种
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> temp = new ArrayList<>();
        final Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(node);
            queue.add(root);
            boolean isStart = true;
            boolean isZigzag = true; // 判断是否倒叙
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (node == poll && isStart) {
                    isStart = false;
                    queue.add(node);
                    if (!temp.isEmpty()) {
                        if(isZigzag){ // 倒叙完成
                            Collections.reverse(temp);
                        }
                        result.add(new ArrayList<>(temp));
                        isZigzag = !isZigzag ; // 将标志取反
                    }
                    temp.clear();
                } else {
                    isStart = true;
                    if (poll != null) {
                        if (poll.left != null) {
                            queue.add(poll.left);
                        }
                        if (poll.right != null) {
                            queue.add(poll.right);
                        }
                        temp.add(poll.val);
                    }
                }
            }
        }
        return result;
    }

    final TreeNode node = new TreeNode(-1);
    private TreeNode start;

    @Override
    public void before() {
        start = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        start = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
    }
}
