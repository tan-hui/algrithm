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
public class PostOrderTraversal {
    public static List<Integer> traverseWithRecursion(TreeNode root) {
        List<Integer> output = Lists.newArrayList();
        doTraverse(root, output);
        return output;
    }

    public static List<Integer> traverseWithIteration(TreeNode root) {
        List<Integer> output = Lists.newArrayList();
        if (root == null) {
            return output;
        }
        TreeNode lastVisitedNode = null;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            }else{
                TreeNode peekNode = stack.peek();
                if (peekNode.getRight() != null && peekNode.getRight() != lastVisitedNode) {
                    curr = peekNode.getRight();
                }else {
                    output.add(peekNode.getVal());
                    lastVisitedNode = stack.pop();
                }
            }
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
        if (node.getRight() != null) {
            doTraverse(node.getRight(), output);
        }
        output.add(node.getVal());
    }
}
