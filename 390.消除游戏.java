// https://leetcode-cn.com/problems/elimination-game/
public class Solution {
    public int lastRemaining(int n) {
        int count = n;
        int first = 1;
        int diff = 1;
        boolean isFromLeft = true;
        while (count > 1) {
            if (isFromLeft) {
                first += diff;
            } else {
                if ((count & 1) == 1) {
                    first += diff;
                }
            }
            count >>>= 1;
            diff <<= 1;
            isFromLeft = !isFromLeft;
        }
        return first;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.lastRemaining(10));
    }
}