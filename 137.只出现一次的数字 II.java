// https://leetcode-cn.com/problems/single-number-ii/
public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() == 1) {
                return item.getKey();
            }
        }
        return -1;
    }

    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        for (int i : nums) {
            set.add(i);
            sum += i;
        }
        long pureSum = 0;
        for (Integer i : set) {
            pureSum += i;
        }
        return (int) ((3 * pureSum - sum) / 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println((solution.singleNumber(new int[]{2, 2, 2, 3})));
    }
}
