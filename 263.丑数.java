// https://leetcode-cn.com/problems/ugly-number/
public class Solution {
    public static int[] model = new int[]{2, 3, 5};

    public boolean isUgly(int num) {
        // 边界条件排除
        if (num <= 0) {
            return false;
        }
        for (int value : model) {
            while (num % value == 0) {
                num /= value;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result" + solution.isUgly(10));
    }
}