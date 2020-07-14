// https://leetcode-cn.com/problems/rotate-image
public class Solution {
    public void rotate(int[][] matrix) {
        int tmp, n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = i * 3 + j + 1;
            }
        }
        solution.rotate(array);
        for (int[] item : array) {
            System.err.println(Arrays.toString(item));
        }
    }
}