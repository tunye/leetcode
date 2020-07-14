// https://leetcode-cn.com/problems/intersection-of-two-arrays
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        int pos = 0;
        for (int i : nums2) {
            if (set.contains(i)) {
                result[pos++] = i;
                set.remove(i);
            }
        }
        return Arrays.copyOfRange(result, 0, pos);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(Arrays.toString(solution.intersection(new int[]{2, 8, 5, 3, 4}, new int[]{11, 4})));
    }
}