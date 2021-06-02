package com.wyz.test.leecode.tree;

import com.wyz.test.TreeNode;
import com.wyz.test.Utils;
import com.wyz.test.leecode.AbstractLeecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层序遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class LevelOrderBottom extends AbstractLeecode {
    @Override
    public void onRun() {
        List<List<Integer>> lists = levelOrder(start);
        for (List<Integer> aa:lists
        ) {
            Utils.printList(aa);
        }
    }

    /**
     * 这个每次添加的时候添加头部即可
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> temp = new ArrayList<>();
        final Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null){
            queue.add(node); // 添加标志物
            queue.add(root); // 添加第一层
            boolean isStart = true;
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll(); // 弹出
                if (node == poll && isStart) { // 判断是标志物
                    isStart = false; // 预防树循环完后 , 前脚添加标志物 后脚就又读出,无法正确中断
                    queue.add(node); // 找到标志物,代表接下来的全为同一层 , 再次将标志物添加到队尾,为下一层和此层进行分割
                    if (!temp.isEmpty()) {// 判断不为空
                        result.add(0 , new ArrayList<>(temp));
                    }
                    temp.clear(); // 清空
                } else {
                    isStart = true;
                    if(poll!= null){
                        if(poll.left!= null){
                            queue.add(poll.left);
                        }
                        if(poll.right!= null){
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
    }
}
