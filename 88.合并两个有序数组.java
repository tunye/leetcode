// https://leetcode-cn.com/problems/merge-sorted-array/submissions/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[m + n - cur] = nums2[j];
                j--;
            } else {
                nums1[m + n - cur] = nums1[i];
                i--;
            }
            cur++;
        }
        if (j >= 0) {
            for (; j >= 0; j--) {
                nums1[m + n - cur] = nums2[j];
                cur++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num1[] = {4, 5, 6, 0, 0, 0};
        int num2[] = {1, 2, 3};
        solution.merge(num1, 3, num2, num2.length);
        System.err.println("result " + Arrays.toString(num1));
    }
}