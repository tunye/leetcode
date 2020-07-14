// https://leetcode-cn.com/problems/subsets-ii/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        handle(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void handle(List<List<Integer>> result, List<Integer> tmp, int[] nums, int start) {
        result.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            handle(result, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[]{1, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(input);
        for (List<Integer> item : result) {
            System.err.println(item.toString());
        }
    }
}