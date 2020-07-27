// https://leetcode-cn.com/problems/search-insert-position
public class Solution {
    public int searchInsert2(int[] nums, int target) {
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

	//另类的找右边界
    public int searchInsert(int[] nums, int target) {
        if (nums[0] >= target) {
            return 0;
        }
        if (nums[nums.length - 1] <= target) {
            return nums[nums.length - 1] == target ? nums.length - 1 : nums.length;
        }
        int result = -1;
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) >>> 1;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}