// https://leetcode-cn.com/problems/happy-number
public class Solution {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        int slower = n;
        int faster = getNext(n);
        while (faster != 1 && slower != faster) {
            slower = getNext(slower);
            faster = getNext(getNext(faster));
        }
        return faster == 1;
    }

    private int getNext(int n) {
        int result = 0;
        int tmp;
        while (n > 0) {
            tmp = n % 10;
            n = n / 10;
            result += tmp * tmp;
        }
        return result;
    }
}