package tree;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

/**
 * 前序遍历
 *
 * @author tanhui
 * @date 2020/8/17 23:53
 */
public class PreOrderTraversal {
    /**
     * 递归遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> traverseWithRecursion(TreeNode root) {
        List<Integer> output = Lists.newArrayList();
        doTraverse(root, output);
        return output;
    }

    /**
     * 迭代遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> traverseWithIteration(TreeNode root) {
        List<Integer> output = Lists.newArrayList();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            output.add(curr.getVal());
            if (curr.getRight() != null) {
                stack.push(curr.getRight());
            }
            if (curr.getLeft() != null) {
                stack.push(curr.getLeft());
            }
        }
        return output;
    }

    public static void doTraverse(TreeNode node, List<Integer> output) {
        if (node == null) {
            return;
        }
        output.add(node.getVal());
        if (node.getLeft() != null) {
            doTraverse(node.getLeft(), output);
        }
        if (node.getRight() != null) {
            doTraverse(node.getRight(), output);
        }
    }
}
