// https://leetcode-cn.com/problems/ugly-number-ii
public class Solution {
    public static final Ugly ugly = new Ugly();

    static class Ugly {
        public final int[] uglyMums = new int[1690];

        public Ugly() {
            uglyMums[0] = 1;
            int ugly = 0;
            int pointFor2 = 0;
            int pointFor3 = 0;
            int pointFor5 = 0;
            for (int i = 1; i < uglyMums.length; i++) {
                ugly = Math.min(uglyMums[pointFor5] * 5, Math.min(uglyMums[pointFor2] * 2, uglyMums[pointFor3] * 3));
                uglyMums[i] = ugly;
                if (uglyMums[pointFor5] * 5 == ugly) {
                    pointFor5++;
                }
                if (uglyMums[pointFor2] * 2 == ugly) {
                    pointFor2++;
                }
                if (uglyMums[pointFor3] * 3 == ugly) {
                    pointFor3++;
                }
            }
        }
    }

    public int nthUglyNumber(int n) {
        return ugly.uglyMums[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.nthUglyNumber(10));
    }
}
