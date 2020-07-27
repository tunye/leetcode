// https://leetcode-cn.com/problems/increasing-subsequences/
public class Solution {
    List<List<Integer>> lists = new LinkedList<>();
    List<Integer> tmp;

    public List<List<Integer>> findSubsequences(int[] nums) {
        tmp = new LinkedList<>();
        doHandle(0, nums);
        return lists;
    }

    private void doHandle(int start, int[] nums) {
        if (tmp.size() >= 2)
            lists.add(new ArrayList<>(tmp));
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            if (tmp.isEmpty() || nums[i] >= tmp.get(tmp.size() - 1)) {
                tmp.add(nums[i]);
                set.add(nums[i]);
                doHandle(i + 1, nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result=solution.findSubsequences(new int[]{4,6,7,7});
        for (List<Integer> item:result){
            System.err.println(item.toString());
        }
    }
}