//https://leetcode-cn.com/problems/combinations/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return result;
        }
        List<Integer> tmp = new ArrayList<>();
        handle(result, tmp, n, k, 1);
        return result;
    }

    private void handle(List<List<Integer>> result, List<Integer> tmp, int n, int k, int start) {
        if (k == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            tmp.add(i);
            handle(result, tmp, n, k - 1, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        handle2(result, tmp, n, k, 1);
        return result;
    }

    private void handle2(List<List<Integer>> result, List<Integer> tmp, int n, int k, int start) {
        if (tmp.size() == k) {
            result.add(new ArrayList<>(tmp));
        }
        for (int i = start; i <= n; i++) {
            if (tmp.size() < k) {
                tmp.add(i);
            } else {
                continue;
            }
            handle(result, tmp, n, k, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combine(4, 2);
        for (List<Integer> item : result) {
            System.err.println(item.toString());
        }
    }
}