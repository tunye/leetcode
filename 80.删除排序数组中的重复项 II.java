// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int cur = 0;
        int interval = 2;
        for (int num : nums) {
            if (cur < interval || num != nums[cur - interval]) {
                nums[cur] = num;
                cur++;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[]{1, 1, 1, 2, 2, 2, 2, 3};
        int result = solution.removeDuplicates(input);
        System.err.println("result " + result + " " + Arrays.toString(input));
    }
}