// https://leetcode-cn.com/problems/two-sum/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Map<Integer, Integer> resolve = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        resolve.put(target - nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (resolve.containsKey(nums[i])) {
                return new int[]{resolve.get(nums[i]), i};
            } else {
                resolve.put(target - nums[i], i);
            }
        }
        return new int[]{1, 2};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result" + Arrays.toString(solution.twoSum(new int[]{2, 15, 1, -6}, 9)));
    }
}