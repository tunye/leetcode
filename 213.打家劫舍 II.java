// https://leetcode-cn.com/problems/house-robber-ii
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int start, int end) {
        int beforeRob = 0, rob = 0;
        for (int i = start; i < end; i++) {
            int tmp = rob;
            rob = Math.max(beforeRob + nums[i], rob);
            beforeRob = tmp;
        }
        return rob;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.rob(new int[]{1, 2, 3, 1}));
    }
}