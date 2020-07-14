// https://leetcode-cn.com/problems/powx-n/
public class Solution {
    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        } else if (x == -1) {
            if (n % 2 == 0) {
                return 1;
            } else {
                return -1;
            }
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                double tmp = x * myPow(x, Integer.MAX_VALUE);
                if (tmp == Double.POSITIVE_INFINITY) {
                    return 0.0;
                }
                return 1 / tmp;
            } else {
                return 1.0 / myPow(x, -n);
            }
        }
        double result = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                result *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return result;
    }

    public double myPow2(double x, int n) {
        boolean negativePow = false;
        boolean yuejie = false;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                negativePow = true;
                n = Integer.MAX_VALUE;
                yuejie = true;
            } else {
                negativePow = true;
                n = -n;
            }
        }
        double tmpResult = 1;
        if (yuejie) {
            tmpResult = x;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                tmpResult *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return negativePow ? 1.0 / tmpResult : tmpResult;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.myPow(2., 2147483647) + " " + solution.myPow2(2., -2147483648));
    }
}