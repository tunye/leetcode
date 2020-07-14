//https://leetcode-cn.com/problems/distribute-candies
public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int i : candies) {
            set.add(i);
        }
        return Math.min(set.size(), candies.length >> 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result "+solution.distributeCandies(new int[]{1,1,4,2,2,3}));
    }
}