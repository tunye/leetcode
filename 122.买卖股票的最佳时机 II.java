// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
// 贪心算法
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit = profit + (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.maxProfit(new int[]{1,2,3,4,5}));
    }
}