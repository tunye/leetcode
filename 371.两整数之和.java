//https://leetcode-cn.com/problems/sum-of-two-integers
public class Solution {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        int lower;
        int carrier;
        while (true) {
            lower = a ^ b;
            carrier = a & b;
            if (carrier == 0) {
                break;
            }
            a = lower;
            b = carrier << 1;
        }
        return lower;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.getSum(11,9));
    }
}