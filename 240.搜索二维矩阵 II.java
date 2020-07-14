// https://leetcode-cn.com/problems/search-a-2d-matrix-ii
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        for (int i = 0, j = matrix[0].length - 1; i < matrix.length && j >= 0; ) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]) {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                input[i][j] = i * 5 + j + 1;
            }
        }
        System.err.println("result " + solution.searchMatrix(input, 25));
    }
}