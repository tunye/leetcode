// https://leetcode-cn.com/problems/pascals-triangle-ii
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(rowIndex + 1);
        long pre = 1;
        ans.add(1);
        for (int k = 1; k <= rowIndex; k++) {
            long cur = pre * (rowIndex - k + 1) / k;
            ans.add((int) cur);
            pre = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> result = solution.getRow(3);
        System.err.println(result.toString());
    }
}