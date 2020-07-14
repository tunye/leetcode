// https://leetcode-cn.com/problems/arranging-coins/
public class Solution {
    public int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }
        int start = 0;
        int end = n;
        int mid;
        long sum;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (mid % 2 == 0) {
                sum = (long)(mid >> 1) * (mid + 1);
            } else {
                sum = (long)mid * ((mid + 1) >> 1);
            }
            if (n == sum) {
                return mid;
            } else if (n > sum) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.arrangeCoins(1804289383));
    }
}