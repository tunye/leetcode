// https://leetcode-cn.com/problems/h-index/
// https://leetcode-cn.com/problems/h-index-ii/
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int start = 0;
        int end = citations.length - 1;
        int mid;
        int result = 0;
        while (start <= end) {
            mid = (start + end) >>> 1;
            if (citations[mid] >= citations.length - mid) {
                result = citations.length - mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.hIndex(new int[]{100}));
    }
}