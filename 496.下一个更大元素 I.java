// https://leetcode-cn.com/problems/next-greater-element-i/
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums2) {
            while (!stack.isEmpty() && i > stack.peek()) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        int pointer = 0;
        for (int i : nums1) {
            result[pointer++] = map.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + Arrays.toString(solution.nextGreaterElement(new int[]{1, 3, 5, 2, 4}, new int[]{6, 5, 4, 3, 2, 1, 7})));
    }
}