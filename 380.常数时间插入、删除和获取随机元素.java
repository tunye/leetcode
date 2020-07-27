// https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
public class Solution {
    Map<Integer, Integer> set;
    List<Integer> tmp;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public Solution() {
        random = new Random();
        set = new HashMap<>();
        tmp = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (set.containsKey(val)) {
            return false;
        }
        set.put(val, tmp.size());
        tmp.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (set.containsKey(val)) {
            int index = set.get(val);
            set.remove(val);
            tmp.set(index, Integer.MIN_VALUE);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index = (int) (Math.random() * tmp.size());
        while (tmp.get(index) == Integer.MIN_VALUE) {
            index = (int) (Math.random() * tmp.size());
        }
        return tmp.get(index);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.insert(1);
        solution.remove(2);
        solution.insert(2);
        System.err.println(solution.getRandom());
        solution.remove(1);
        solution.insert(2);
        System.err.println(solution.getRandom());
    }
}