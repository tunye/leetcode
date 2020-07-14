// https://leetcode-cn.com/problems/single-number-iii/
public class Solution {
    public int[] singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        int tmp = result & -result;
        int result1 = 0;

        for (int i : nums) {
            if ((i & tmp) != 0) {
                result1 ^= i;
            }
        }
        return new int[]{result1, result1 ^ result};
    }

    public int[] singleNumber2(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        int tmp = 1;
        while ((result & 1) != 1) {
            result = result >> 1;
            tmp = tmp << 1;
        }
        List<Integer> sort1 = new ArrayList<>();
        List<Integer> sort2 = new ArrayList<>();
        for (int i : nums) {
            if ((i & tmp) == tmp) {
                sort1.add(i);
            } else {
                sort2.add(i);
            }
        }
        int result1 = 0;
        int result2 = 0;
        for (int i : sort1) {
            result1 ^= i;
        }
        for (int i : sort2) {
            result2 ^= i;
        }
        return new int[]{result1, result2};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(Arrays.toString(solution.singleNumber(new int[]{2, 1, 2, 5})));
    }
}