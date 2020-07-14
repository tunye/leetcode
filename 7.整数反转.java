// https://leetcode-cn.com/problems/reverse-integer/
public class Solution {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.reverse(-123));
    }
}