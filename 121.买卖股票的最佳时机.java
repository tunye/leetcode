// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/submissions/
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int curMin = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit = Math.max(profit, prices[i] - curMin);
            } else {
                curMin = Math.min(curMin, prices[i]);
            }
        }
        return profit;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}