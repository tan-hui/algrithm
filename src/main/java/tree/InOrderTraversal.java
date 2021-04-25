package tree;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 *
 * @author tanhui
 * @date 2020/8/17 23:53
 */
public class InOrderTraversal {
    /**
     * 递归遍历
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
     * @param root
     * @return
     */
    public static List<Integer> traverseWithIteration(TreeNode root) {
        List<Integer> output = Lists.newArrayList();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            }
            TreeNode node = stack.pop();
            output.add(node.getVal());
            curr = node.getRight();
        }
        return output;
    }

    public static void doTraverse(TreeNode node, List<Integer> output) {
        if (node == null) {
            return;
        }
        if (node.getLeft() != null) {
            doTraverse(node.getLeft(), output);
        }
        output.add(node.getVal());
        if (node.getRight() != null) {
            doTraverse(node.getRight(), output);
        }
    }
}
