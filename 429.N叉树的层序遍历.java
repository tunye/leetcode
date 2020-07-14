// https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
public class Solution {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<Integer> tmp;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node cur;
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                tmp.add(cur.val);
                for (Node item : cur.children) {
                    if (item != null) {
                        queue.offer(item);
                    }
                }
            }
            result.add(tmp);
        }
        return result;
    }
}