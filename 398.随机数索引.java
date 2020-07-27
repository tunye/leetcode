// https://leetcode-cn.com/problems/random-pick-index/
 class Solution {
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int n = 0;
            int index = 0;
            for (int i = 0; i < nums.length; i++)
                if (nums[i] == target) {
                    n++;
                    if ((int) (Math.random() * n) % n == 0) {
                        index = i;
                    }
                }
            return index;
        }
    }