// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
public class Solution {
    public int findMinFor154(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0, high = nums.length - 1;
        while (low < high && nums[low] >= nums[high]) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return nums[low];
    }

    public int findMinFor153(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            min = Math.min(min, nums[i]);
            min = Math.min(min, nums[j]);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.findMinFor154(new int[]{3, 1, 3});
        System.err.println("result " + result);
    }
}