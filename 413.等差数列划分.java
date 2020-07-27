// https://leetcode-cn.com/problems/arithmetic-slices/
public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                count++;
            } else {
                sum += (count + 1) * (count) / 2;
                count = 0;
            }
        }
        return sum + count * (count + 1) / 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.numberOfArithmeticSlices(new int[]{1, 3, 5, 7, 8}));
    }
}