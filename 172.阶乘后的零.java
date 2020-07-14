// https://leetcode-cn.com/problems/factorial-trailing-zeroes
public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.trailingZeroes(30) + " ");
    }
}