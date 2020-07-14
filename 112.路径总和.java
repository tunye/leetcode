// https://leetcode-cn.com/problems/path-sum/
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode input = new TreeNode(5);
        TreeNode tmp = input;
        tmp.left = new TreeNode(4);
        tmp.right = new TreeNode(8);
        TreeNode tmp1 = tmp.left;
        tmp1.left = new TreeNode(11);
        tmp1.right = null;
        TreeNode tmp2 = tmp.right;
        tmp2.left = new TreeNode(13);
        tmp2.right = new TreeNode(4);
        TreeNode tmp3 = tmp1.left;
        tmp3.left = new TreeNode(7);
        tmp3.right = new TreeNode(2);
        TreeNode tmp4 = tmp2.right;
        tmp4.left = new TreeNode(5);
        tmp4.right = new TreeNode(1);
        System.err.println("result "+solution.hasPathSum(input, 22));
    }
}