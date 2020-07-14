// https://leetcode-cn.com/problems/missing-number-lcci
public class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result += i - nums[i];
        }
        return Math.abs(result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}