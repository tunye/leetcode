// https://leetcode-cn.com/problems/sqrtx/submissions/
public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        // 牛顿方程
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-6) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int result = 0;
        long target = x;
        for (long i = 0; i < target; i++) {
            if (i * i < target) {
                result = (int) i;
            } else {
                if (i * i == target) {
                    result = (int) i;
                }
                break;
            }
        }
        return result;
    }

    public int mySqrt3(int x) {
        int left = 0, right = x, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.mySqrt(2147483647));
    }
}