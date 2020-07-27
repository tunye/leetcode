// https://leetcode-cn.com/problems/number-complement/
// https://leetcode-cn.com/problems/complement-of-base-10-integer/
class Solution {
    public int findComplement(int num) {
    	if (num == 0){
            return 1;
        }
        int tmp = num;
        int num2 = 1;
        while (tmp > 0) {
            num2 <<= 1;
            tmp >>= 1;
        }
        num2 -= 1;
        return num ^ num2;
    }
}