// https://leetcode-cn.com/problems/combination-sum
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (target - candidates[i] < 0) {
                break;
            }
            tmp.add(candidates[i]);
            handle(result, tmp, candidates, target - candidates[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> item : result) {
            System.err.println(item.toString());
        }
    }
}