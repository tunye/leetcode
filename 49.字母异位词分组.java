// https://leetcode-cn.com/problems/group-anagrams
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        int[] zhishu = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        HashMap<Long, List<String>> result = new HashMap<>();
        long hashcode = 1;
        for (String item : strs) {
            hashcode = 1;
            for (int i = 0; i < item.length(); i++) {
                hashcode *= zhishu[item.charAt(i) - 'a'];
            }
            if (result.containsKey(hashcode)) {
                result.get(hashcode).add(item);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(item);
                result.put(hashcode, tmp);
            }
        }
        return new ArrayList<>(result.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> result = new HashMap<>();
        int[] directory;
        for (String item : strs) {
            directory = new int[26];
            for (int i = 0; i < item.length(); i++) {
                directory[item.charAt(i) - 'a']++;
            }
            String counts = getCounts(directory);
            if (result.containsKey(counts)) {
                result.get(counts).add(item);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(item);
                result.put(counts, tmp);
            }
        }
        return new ArrayList<>(result.values());
    }

    public String getCounts(int[] directory) {
        StringBuilder sb = new StringBuilder();
        int pos = -1;
        for (int i : directory) {
            pos++;
            if (i == 0) {
                continue;
            }
            sb.append(('a' + pos)).append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> result = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.err.println("result ");
        for (List<String> item : result) {
            System.err.println(Arrays.toString(item.toArray()));
        }
    }
}