// https://leetcode-cn.com/problems/binary-tree-right-side-view
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int levelEnd = -1;
        TreeNode curNode;
        while (queue.size() > 0) {
            curNode = queue.poll();
            if (curNode != null) {
                levelEnd = curNode.val;
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            } else {
                result.add(levelEnd);
                if (queue.size() > 0) {
                    queue.add(null);
                }
            }
        }
        return result;
    }
}