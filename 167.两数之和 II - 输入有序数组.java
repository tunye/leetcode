//https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
public class Solution {
	//有序数组，可以对头查找了
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i < j; ) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i + 1, j + 1};
            } else {
                if (nums[i] + nums[j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return new int[]{1, 2};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + Arrays.toString(solution.twoSum(new int[]{2, 3, 7, 9, 15, 25}, 12)));
    }
}