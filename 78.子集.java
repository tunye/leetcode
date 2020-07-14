// https://leetcode-cn.com/problems/subsets/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        handle(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void handle(List<List<Integer>> result, List<Integer> tmp, int[] nums, int start) {
        result.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            handle(result, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[]{1, 2, 3};
        List<List<Integer>> result = solution.subsets(input);
        for (List<Integer> item : result) {
            System.err.println(item.toString());
        }
    }
}