// https://leetcode-cn.com/problems/first-bad-version/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int mid;
        while (start < end) {
            mid = start + ((end - start) >> 1);
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}