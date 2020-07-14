// https://leetcode-cn.com/problems/search-insert-position
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (i == nums.length - 1 || nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}