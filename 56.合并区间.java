// https://leetcode-cn.com/problems/merge-intervals
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });
        int pointer = 0;
        for (int i = 0, j = i + 1; i < intervals.length; i++) {
            intervals[pointer][0] = intervals[i][0];
            while (j < intervals.length && intervals[i][1] >= intervals[j][0]) {
                intervals[i][1] = Math.max(intervals[j][1], intervals[i][1]);
                j++;
            }
            intervals[pointer][1] = intervals[i][1];
            pointer++;
            i = j - 1;
        }
        return Arrays.copyOf(intervals, pointer);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[3][2];
        intervals[0] = new int[]{1, 4};
        intervals[1] = new int[]{0, 5};
        int[][] result = solution.merge(intervals);
        System.err.println("result");
        for (int i = 0; i < result.length; i++) {
            System.err.println(Arrays.toString(result[i]));
        }
    }
}