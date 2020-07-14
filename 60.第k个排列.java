// https://leetcode-cn.com/problems/permutation-sequence
public class Solution {
    public String getPermutation(int n, int k) {
        List<String> directory = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            directory.add(Integer.toString(i));
        }
        int i = 0, fab = 0;
        while (n != 0) {
            fab = fab(n - 1);
            i = (int) (Math.ceil(k * 1d / fab) - 1);
            result.append(directory.get(i));
            directory.remove(i);
            k -= fab * i;
            n--;
        }
        return result.toString();
    }

    private int fab(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.getPermutation(4, 9));
    }
}