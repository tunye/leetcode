// https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        int[] result = new int[nums1.length];
        int count;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        int pos = 0;
        for (int num : nums2) {
            count = map.getOrDefault(num, 0);
            if (count > 0) {
                result[pos++] = num;
                if (count == 1) {
                    map.remove(num);
                } else {
                    map.put(num, count - 1);
                }
            }
        }
        return Arrays.copyOfRange(result, 0, pos);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(Arrays.toString(solution.intersect(new int[]{9, 4, 9, 8, 4}, new int[]{4, 9, 5})));
    }
}