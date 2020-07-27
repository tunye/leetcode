// https://leetcode-cn.com/problems/divisor-game/
public class Solution {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.divisorGame(3));
    }
}