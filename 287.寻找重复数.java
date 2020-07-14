// https://leetcode-cn.com/problems/find-the-duplicate-number/
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}