// https://leetcode-cn.com/problems/search-a-2d-matrix/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int colomn = matrix[0].length;

        int left = 0, right = row * colomn - 1;
        int mid, midValue;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            midValue = matrix[mid / colomn][mid % colomn];
            if (target == midValue) {
                return true;
            } else {
                if (target < midValue) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}