//https://leetcode-cn.com/problems/3sum/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneResult;
        // 先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            } else if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } else {
                for (int j = i + 1, k = nums.length - 1; j < k; ) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        oneResult = new ArrayList<>();
                        oneResult.add(nums[i]);
                        oneResult.add(nums[j]);
                        oneResult.add(nums[k]);
                        result.add(oneResult);
                        while (nums[j] == nums[j + 1] && j < k - 1) {
                            j++;
                        }
                        j++;
                        k--;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(new int[]{0, 0, 0, 0});
        System.err.println("result");
        System.err.println("{");
        for (List<Integer> item : result) {
            System.err.print("[");
            for (Integer pos : item) {
                System.err.print(pos);
                System.err.print(',');
            }
            System.err.println("]");
        }
        System.err.println("}");
    }
}