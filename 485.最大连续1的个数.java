// https://leetcode-cn.com/problems/max-consecutive-ones/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int tmp = 0;
        for (int i : nums) {
            if (i == 1) {
                tmp++;
            } else {
                result = Math.max(result, tmp);
                tmp = 0;
            }
        }
        return Math.max(result, tmp);
    }
}