// https://leetcode-cn.com/problems/power-of-three/
public class Solution {
    public static Set<Integer> dp = new HashSet<>();

    static {
        dp.add(3);
        dp.add(9);
        dp.add(27);
        dp.add(81);
        dp.add(243);
    }

    public boolean isPowerOfThree(int n) {
        int input = n;
        while (n > 2) {
            if (dp.contains(n)) {
                dp.add(input);
                return true;
            }
            if (n % 3 == 0) {
                n = n / 3;
            } else {
                return false;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.isPowerOfThree(45));
    }
}