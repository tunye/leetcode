// https://leetcode-cn.com/problems/third-maximum-number/
public class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int curPos = 0;
        int pre = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            while (nums[i] == pre && i > 0) {
                i--;
            }
            if (pre != nums[i]) {
                pre = nums[i];
                curPos++;
            }
            if (curPos == 2) {
                return pre;
            }
        }
        return nums[nums.length - 1];
    }

    public int thirdMax2(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
            if (set.size() > 3) {
                set.remove(set.pollFirst());
            }
        }
        if (set.size() < 3) {
            return set.last();
        } else {
            return set.first();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.thirdMax(new int[]{5,2,4,1,3,6,0}));
    }
}