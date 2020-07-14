// https://leetcode-cn.com/problems/recover-binary-search-tree
public class Solution {
    TreeNode x, y, last;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void swap() {
        if (x == null || y == null) {
            return;
        }
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    private void findSwapNode(TreeNode root) {
        if (root == null) {
            return;
        }
        findSwapNode(root.left);
        if (last != null && root.val < last.val) {
            y = root;
            if (x == null) {
                x = last;
            } else {
                return;
            }
        }
        last = root;
        findSwapNode(root.right);
    }

    public void recoverTree(TreeNode root) {
        findSwapNode(root);
        swap();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode input = new TreeNode(1);
        input.left = new TreeNode(3);
        input.right = null;
        TreeNode tmp = input.left;
        tmp.right = new TreeNode(2);
        tmp.left = null;

        solution.recoverTree(input);
    }
}