// https://leetcode-cn.com/problems/shift-2d-grid
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int column = grid.length;
        int row = grid[0].length;
        int[] tmp = new int[column * row];
        int pos = 0;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                tmp[pos++] = grid[i][j];
            }
        }
        rotate(tmp, k);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> rowTmp;
        for (int i = 0; i < tmp.length; ) {
            rowTmp = new ArrayList<>();
            for (int j = 0; j < row; j++) {
                rowTmp.add(tmp[i + j]);
            }
            result.add(rowTmp);
            i += row;
        }
        return result;
    }

    public void rotate(int[] nums, int k) {
        if (k % nums.length != 0) {
            k = k % nums.length;
            reverse(nums, 0, nums.length - k - 1);
            reverse(nums, nums.length - k, nums.length - 1);
            reverse(nums, 0, nums.length - 1);
        }
    }

    public void reverse(int[] nums, int start, int end) {
        for (; start < end; start++, end--) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nums[i][j] = i * 3 + j+1;
            }
            System.err.println(Arrays.toString(nums[i]));
        }
        List<List<Integer>> result = solution.shiftGrid(nums, 1);
        for (List<Integer> item : result) {
            System.err.println(item.toString());
        }
    }
}