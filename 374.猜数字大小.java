// https://leetcode-cn.com/problems/guess-number-higher-or-lower/
public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int start = 1;
            int end = n;
            int mid;
            while (start <= end) {
                mid = (start + end) >>> 1;
                if (guess(mid) == 0) {
                    return mid;
                } else if (guess(mid) == -1) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return -1;
        }
    }