// https://leetcode-cn.com/problems/jump-game/
public class Solution {
    // 动归，看是否可以跳到倒数第n个
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 逐步向前递推
            if (nums[i] + i >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }

    // 贪心
    public boolean canJump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.canJump(new int[]{3, 0, 0, 0}));
    }
}