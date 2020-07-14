// https://leetcode-cn.com/problems/majority-element-ii
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        } else if (nums.length == 1) {
            List<Integer> result = new ArrayList<>(1);
            result.add(nums[0]);
            return result;
        }
        int compareCount = nums.length / 3;
        int support1 = 0;
        int support2 = 0;
        int result1 = 0;
        int result2 = 0;
        for (int i : nums) {
            if (result1 == i) {
                support1++;
            } else if (result2 == i) {
                support2++;
            } else if (support1 == 0) {
                result1 = i;
                support1 = 1;
            } else if (support2 == 0) {
                result2 = i;
                support2 = 1;
            } else {
                support1--;
                support2--;
            }
        }
        int count1 = 0, count2 = 0;
        List<Integer> result = new ArrayList<>();
        for (int i : nums) {
            if (i == result1) {
                count1++;
            } else if (i == result2) {
                count2++;
            }
            if (count1 > compareCount && count2 > compareCount) {
                break;
            }
        }
        if (count1 > compareCount) {
            result.add(result1);
        }
        if (count2 > compareCount) {
            result.add(result2);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.majorityElement(new int[]{0,0,0}));
    }
}