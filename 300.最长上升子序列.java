// https://leetcode-cn.com/problems/longest-increasing-subsequence/
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (tails[result] < nums[i]) {
                tails[++result] = nums[i];
            } else {
                int start = 0;
                int end = result;
                int mid;
                while (start < end) {
                    mid = (start + end) >>> 1;
                    if (tails[mid] < nums[i]) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                tails[start] = nums[i];
            }
        }
        return result + 1;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}