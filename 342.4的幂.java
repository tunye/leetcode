// https://leetcode-cn.com/problems/power-of-four/
public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }

    public boolean isPowerOfFour2(int num) {
        if (num == 1) return true;
        if (num < 4) return false;

        if ((num & (num - 1)) != 0) return false;

        return (num & 0x55555555) == num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.isPowerOfFour(16));
    }
}