// https://leetcode-cn.com/problems/top-k-frequent-elements/
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (queue.size() < k || entry.getValue() > queue.peek().getValue()) {
                queue.offer(new Pair<>(entry.getKey(), entry.getValue()));
            }
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] finalResult = new int[k];
        for (int i = 0; i < k; i++) {
            finalResult[i] = queue.poll().getKey();
        }
        return finalResult;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            result.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            result.get(entry.getValue()).add(entry.getKey());
        }
        List<Integer> returnData = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            returnData.addAll(result.get(i));
            if (returnData.size() > k) {
                break;
            }
        }
        int[] finalResult = new int[k];
        for (int i = 0; i < k; i++) {
            finalResult[i] = returnData.get(i);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.topKFrequent(new int[]{-1, -1}, 1);
        System.err.println("result " + Arrays.toString(result));
    }
}