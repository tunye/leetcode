// https://leetcode-cn.com/problems/valid-perfect-square/
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        } else {
            int start = 2;
            int end = num >>> 1;
            int mid;
            long tmpMulti;
            while (start <= end) {
                mid = (start + end) >>> 1;
                tmpMulti = mid * 1L * mid;
                if (tmpMulti == num) {
                    return true;
                } else if (tmpMulti < num) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.isPerfectSquare(808201));
    }
}