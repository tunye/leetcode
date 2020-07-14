// https://leetcode-cn.com/problems/move-zeroes/
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int legalPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[legalPos++] = nums[i];
            }
        }
        for (; legalPos < nums.length; legalPos++) {
            nums[legalPos] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1, 12, 0, 13, 0};
        solution.moveZeroes(nums);
        System.err.println(Arrays.toString(nums));
    }
}