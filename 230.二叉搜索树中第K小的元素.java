// https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/submissions/
// https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthLargest(TreeNode root, int k) {
        int count = 1;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            TreeNode cur = stack.pop();
            if (count == k) {
                return cur.val;
            }
            count++;
            root = cur.left;
        }
        return -1;
    }

    public int kthSmallest(TreeNode root, int k) {
        int count = 1;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            if (count == k) {
                return cur.val;
            }
            count++;
            root = cur.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println((solution.singleNumber(new int[]{2, 2, 2, 3})));
    }
}