//https://leetcode-cn.com/problems/roman-to-integer/

public class Solution {

    public int romanToInt(String s) {
        int result = 0;
        int preNum = 0;
        for (char c : s.toCharArray()) {
            if (reflect(c) > preNum && preNum != 0) {
                result -= preNum;
            } else {
                result += preNum;
            }
            preNum = reflect(c);
        }
        result += preNum;
        return result;
    }

    public int reflect(char c) {
        switch (c) {
            default:
                return 0;
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
    }

    public int romanToInt2(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int count = 0;
        for (int i = 0; i < s.length(); ) {
            if (i < s.length() - 1) {
                String trik = s.substring(i, i + 2);
                if (map.containsKey(trik)) {
                    count += map.get(trik);
                    i += 2;
                } else {
                    count += map.get(Character.toString(s.charAt(i)));
                    i++;
                }
            } else {
                count += map.get(Character.toString(s.charAt(i)));
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.romanToInt("IM"));
    }
}