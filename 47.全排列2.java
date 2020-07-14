//https://leetcode-cn.com/problems/permutations-ii
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        handle(result, tmp, nums, 0, visited);
        return result;
    }

    public void handle(List<List<Integer>> result, List<Integer> tmp, int[] nums, int start, boolean[] visited) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > start && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }

            tmp.add(nums[i]);
            visited[i] = true;
            handle(result, tmp, nums, start, visited);
            visited[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.permuteUnique(new int[]{1, 2, 1});
        for (List<Integer> item : result) {
            System.err.println(item.toString());
        }
    }
}