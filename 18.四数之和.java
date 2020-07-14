// https://leetcode-cn.com/problems/4sum/
// 注意 此解答会超时。
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        handle(result, tmp, nums, target, 0);
        return result;
    }

    private void handle(List<List<Integer>> result, List<Integer> tmp, int[] nums, int target, int start) {
        if (target == 0 && tmp.size() == 4) {
            result.add(new ArrayList<>(tmp));
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            } else if (tmp.size() < 4) {
                tmp.add(nums[i]);
            } else {
                continue;
            }
            handle(result, tmp, nums, target - nums[i], i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.fourSum(new int[]{-5,5,4,-3,0,0,4,-2}, 4);
        for (List<Integer> item : result) {
            System.err.println(item.toString());
        }
    }
}