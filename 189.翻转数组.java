// https://leetcode-cn.com/problems/rotate-array
public class Solution {
    public void rotate(int[] nums, int k) {
        if (k % nums.length != 0) {
            k = k % nums.length;
            reverse(nums, 0, nums.length - k - 1);
            reverse(nums, nums.length - k, nums.length - 1);
            reverse(nums, 0, nums.length - 1);
        }
    }

    public void reverse(int[] nums, int start, int end) {
        for (; start < end; start++, end--) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        System.err.println(Arrays.toString(nums));
    }
}