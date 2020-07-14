// https://leetcode-cn.com/problems/house-robber/
public class Solution {
    public int rob(int[] nums) {
        int beforeRob = 0, rob = 0;
        for (int i : nums) {
            int tmp = rob;
            rob = Math.max(beforeRob + i, rob);
            beforeRob = tmp;
        }
        return rob;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.rob(new int[]{2}));
    }
}
