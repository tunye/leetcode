// https://leetcode-cn.com/problems/largest-number
public class Solution {
    public String largestNumber(int[] nums) {
        List<String> numbers = new ArrayList<>(nums.length);
        for (int i : nums) {
            numbers.add(Integer.toString(i));
        }
        numbers.sort((o1, o2) -> {
            String new1 = o1 + o2;
            String new2 = o2 + o1;
            return new2.compareTo(new1);
        });
        if (numbers.get(0).equals("0")) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String item : numbers) {
            stringBuilder.append(item);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println(solution.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}