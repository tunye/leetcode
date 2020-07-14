// https://leetcode-cn.com/problems/spiral-matrix-ii/
public class Solution {
    public int[][] generateMatrix(int n) {
        int min = 0;
        int max = n;
        int i, j;
        int[][] result = new int[n][n];
        int tmp = 0;
        while (min <= max) {
            for (i = min, j = min; j < max; j++) {
                result[i][j] = ++tmp;
            }
            for (j--, tmp--; i < max; i++) {
                result[i][j] = ++tmp;
            }
            for (i--, tmp--; j >= min; j--) {
                result[i][j] = ++tmp;
            }
            for (j++, tmp--; i >= min + 1; i--) {
                result[i][j] = ++tmp;
            }
            min++;
            max--;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] result = solution.generateMatrix(4);
        for (int[] item : result) {
            System.err.println(Arrays.toString(item));
        }
    }
}