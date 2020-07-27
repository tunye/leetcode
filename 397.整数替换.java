// https://leetcode-cn.com/problems/integer-replacement/
public class Solution {
    public int integerReplacement2(int n) {
        int count = 0;
        while (n > 1) {
            if ((n & 1) == 0) {
                n = n >> 1;
            } else {
                if (n != 3 && ((n + 1) & 3) == 0) {
                    n = (n >> 1) + 1;
                    count++;
                } else {
                    n--;
                }
            }
            count++;
        }
        return count;
    }

    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) {
            return 32;
        } else {
            return doReplace(n);
        }
    }

    private int doReplace(int n) {
        if (n == 1) {
            return 0;
        } else if (n < 4) {
            return n - 1;
        } else {
            if (n % 2 == 0) {
                return doReplace(n / 2) + 1;
            } else {
                return (n & 2) == 0 ? integerReplacement(n - 1) + 1 : integerReplacement(n + 1) + 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.integerReplacement(3));
    }
}