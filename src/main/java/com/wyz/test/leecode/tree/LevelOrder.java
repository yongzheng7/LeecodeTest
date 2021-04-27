package com.wyz.test.leecode.tree;

import com.wyz.test.TreeNode;
import com.wyz.test.Utils;
import com.wyz.test.leecode.AbstractLeecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder extends AbstractLeecode {

    /**
     * 分析
     * 1 给定一个二叉树 , 需要返回每一层的所有的数作为一个数组
     * 这样的话 不能使用递归 , 因为递归的话 树的子树之间是没有任何联系的
     * 而该题 需要将同一层的所有子树的数 打包成一个数组
     * 我的想法
     * 1 通过队列和标志物 区分每一层
     */
    @Override
    public void onRun() {
        List<List<Integer>> lists = levelOrder(start);
        for (List<Integer> aa:lists
             ) {
            Utils.printList(aa);
        }
    }

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
                        result.add(new ArrayList<>(temp));
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
    public List<List<Integer>> levelOrder2(TreeNode root) {
        //按层遍历即可
        //1.
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        //2.
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode remove = nodes.remove(0);
                list.add(remove.val);
                if (remove.left != null) {
                    nodes.add(remove.left);
                }
                if (remove.right != null) {
                    nodes.add(remove.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
    final TreeNode node = new TreeNode(-1);
    private TreeNode start;
    @Override
    public void before() {
        start = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        start = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
    }

}
