// https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        } else {
            stack.add(new Pair<>(root, 1));
        }

        int min_depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pollLast();
            root = current.getKey();
            int current_depth = current.getValue();
            if ((root.left == null) && (root.right == null)) {
                min_depth = Math.min(min_depth, current_depth);
            }
            if (root.left != null) {
                stack.add(new Pair<>(root.left, current_depth + 1));
            }
            if (root.right != null) {
                stack.add(new Pair<>(root.right, current_depth + 1));
            }
        }
        return min_depth;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        int minHeight = Integer.MAX_VALUE;
        if (root.left != null) {
            minHeight = Math.min(minHeight, minDepth2(root.left));
        }
        if (root.right != null) {
            minHeight = Math.min(minHeight, minDepth2(root.right));
        }
        return minHeight + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        TreeNode treeNode1 = treeNode.right;
        treeNode1.left = new TreeNode(5);
        treeNode1.right = new TreeNode(7);
        System.err.println(solution.minDepth2(treeNode));
    }
}