// https://leetcode-cn.com/problems/contains-duplicate
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> remove = new HashSet<>(nums.length);
        for (int i : nums) {
            if (remove.contains(i)) {
                return true;
            }
            remove.add(i);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.containsDuplicate(new int[]{5,7}));
    }
}