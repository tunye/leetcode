// https://leetcode-cn.com/problems/assign-cookies/
public class Solution {
    public int findContentChildren(int[] grid, int[] size) {
        if (grid == null || size == null) {
            return 0;
        }
        Arrays.sort(grid);
        Arrays.sort(size);
        int gPointer = 0, sPointer = 0;
        while (gPointer < grid.length && sPointer < size.length) {
            if (grid[gPointer] <= size[sPointer]) {
                gPointer++;
            }
            sPointer++;
        }
        return gPointer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.findContentChildren(new int[]{1,2},new int[]{1,1}));
    }
}