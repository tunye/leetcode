//https://leetcode-cn.com/problems/add-binary
public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int addNextPos = 0;
        int i = a.length() - 1, j = b.length() - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            addNextPos = addPos(result, addNextPos + (a.charAt(i) - '0') + (b.charAt(j) - '0'));
        }
        if (i >= 0) {
            addNextPos = addRemainPos(i, a, result, addNextPos);
        }
        if (j >= 0) {
            addNextPos = addRemainPos(j, b, result, addNextPos);
        }

        return (addNextPos == 1 ? "1" : "") + result.reverse().toString();
    }

    private int addPos(StringBuilder result, int cur) {
        result.append(cur % 2);
        if (cur >= 2) {
            return 1;
        } else {
            return 0;
        }
    }

    private int addRemainPos(int pointer, String resource, StringBuilder result, int addNextPos) {
        for (; pointer >= 0; pointer--) {
            addNextPos = addNextPos + (resource.charAt(pointer) - '0');
            addNextPos = addPos(result, addNextPos);
        }
        return addNextPos;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.addBinary("1111", "1111"));
    }
}