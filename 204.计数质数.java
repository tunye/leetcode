// https://leetcode-cn.com/problems/count-primes/
public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        int tmpFlag = 4;
        for (int i = 2; tmpFlag < n; i++) {
            tmpFlag = i * i;
            if (isPrim[i]) {
                for (int j = tmpFlag; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.countPrimes(10));
    }
}