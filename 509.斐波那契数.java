// https://leetcode-cn.com/problems/fibonacci-number/
public class Solution {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1 || N == 2) {
            return 1;
        } else {
            int pre = 1;
            int cur = 1;
            int tmp = 0;
            while (N >= 3) {
                tmp = cur + pre;
                pre = cur;
                cur = tmp;
                N--;
            }
            return cur;
        }
    }
}