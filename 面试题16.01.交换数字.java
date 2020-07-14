// https://leetcode-cn.com/problems/swap-numbers-lcci
public class Solution {

    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[1] ^ numbers[0];
        numbers[0] = numbers[1] ^ numbers[0];
        return numbers;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = new int[]{1, 2};
        num = solution.swapNumbers(num);
        System.err.println("result " + Arrays.toString(num));
    }
}