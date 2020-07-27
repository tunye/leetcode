// https://leetcode-cn.com/problems/binary-watch/
// 也可使用回溯法。
public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            int hBitCountVal = Integer.bitCount(h);
            if (hBitCountVal > num) {
                continue;
            }
            for (int m = 0; m < 60; m++) {
                int mBitCountVal = Integer.bitCount(m);
                if (mBitCountVal > num) {
                    continue;
                }
                int bigCountVal = hBitCountVal + mBitCountVal;
                if (bigCountVal == num) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.readBinaryWatch(1).toString());
    }
}
