// https://leetcode-cn.com/problems/maximum-product-subarray/submissions/
public class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        int tmp;
        for (int i = 1; i < nums.length; i++) {
            tmp = max;
            max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * tmp, nums[i] * min));
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.maxProduct(new int[]{-2, 0, -1});
        System.err.println("result " + result);
    }
}