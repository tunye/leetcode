// https://leetcode-cn.com/problems/linked-list-random-node/
class Solution {
        private int size = 0;
        private ListNode head;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
            ListNode tmp = head;
            while (tmp != null) {
                size++;
                tmp = tmp.next;
            }
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            ListNode tmp = head;
            int random = (int) (Math.random() * size);
            while (random > 0) {
                tmp = tmp.next;
                random--;
            }
            return tmp.val;
        }
    }