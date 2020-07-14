// https://leetcode-cn.com/problems/unique-binary-search-trees
public class Solution {
    Map<Integer, Integer> dict = new HashMap<>();

    public int numTrees(int n) {
        if (dict.containsKey(n)) {
            return dict.get(n);
        }
        if (n <= 1) {
            return 1;
        } else {
            int tmp = 0;
            for (int i = 1; i < n + 1; i++) {
                tmp += numTrees(i - 1) * numTrees(n - i);
            }
            dict.put(n, tmp);
            return tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result "+solution.numTrees(3));
    }
}