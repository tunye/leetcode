// https://leetcode-cn.com/problems/combination-sum-ii/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        handle(result, tmp, candidates, target, 0);
        return result;
    }

    public void handle(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 与39不同一点，增强剪枝
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }
            tmp.add(candidates[i]);
            // 与39不同一点
            handle(result, tmp, candidates, target - candidates[i], i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> item : result) {
            System.err.println(item.toString());
        }
    }
}