//https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
import java.util.ArrayList;
import java.util.List;

public class Solution {
   public static final String[] digitChar = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        letterCombinationsDo(digits, 0, "", result);
        return result;
    }

    private void letterCombinationsDo(String digits, int pos, String tmp, List<String> result) {
        if (pos == digits.length()) {
            result.add(tmp);
        } else {
            String chars = digitChar[digits.charAt(pos++) - '0'];
            for (int i = 0; i < chars.length(); i++) {
                letterCombinationsDo(digits, pos, tmp + chars.charAt(i), result);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations("239");
        System.err.println("result "+result.size());
        System.err.print("[");
        for (String item : result) {
            System.err.print(item);
            System.err.println(',');
        }
        System.err.println("]");
    }
}