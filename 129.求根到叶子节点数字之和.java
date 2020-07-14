// https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        return handle(root, result);
    }

    private int handle(TreeNode root, int result) {
        if (root == null) {
            return 0;
        }
        int nextResult = result * 10 + root.val;
        if (root.left == null && root.right == null) {
            return nextResult;
        }
        return handle(root.left, nextResult) + handle(root.right, nextResult);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode input = new TreeNode(1);
        TreeNode tmp = input;
        tmp.left = new TreeNode(2);
        tmp.right = new TreeNode(3);
//        TreeNode tmp1 = tmp.left;
//        tmp1.left = new TreeNode(11);
//        tmp1.right = null;
//        TreeNode tmp2 = tmp.right;
//        tmp2.left = new TreeNode(13);
//        tmp2.right = new TreeNode(4);
//        TreeNode tmp3 = tmp1.left;
//        tmp3.left = new TreeNode(7);
//        tmp3.right = new TreeNode(2);
//        TreeNode tmp4 = tmp2.right;
//        tmp4.left = new TreeNode(5);
//        tmp4.right = new TreeNode(1);
        System.err.println("result " + solution.sumNumbers(input));
    }
}