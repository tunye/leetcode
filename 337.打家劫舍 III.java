// https://leetcode-cn.com/problems/house-robber-iii/
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode nums) {
        int[] result = dp(nums);
        return Math.max(result[0], result[1]);
    }

    /**
     * 返回一个大小为 2 的数组 arr
     * arr[0] 表示不抢 root 的话，得到的最大钱数
     * arr[1] 表示抢 root 的话，得到的最大钱数
     **/
    int[] dp(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 抢，下家就不能抢了
        int rob = root.val + left[0] + right[0];
        // 不抢，下家可抢可不抢，取决于收益大小
        int not_rob = Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);

        return new int[]{not_rob, rob};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode treeNode1 = root.left;
        treeNode1.right = new TreeNode(3);
        TreeNode treeNode2 = root.right;
        treeNode2.right = new TreeNode(1);
        System.err.println("result " + solution.rob(root));
    }
}
