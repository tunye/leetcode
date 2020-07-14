// https://leetcode-cn.com/problems/find-median-from-data-stream
public class MedianFinder {
    PriorityQueue<Integer> high;
    PriorityQueue<Integer> low;

    public MedianFinder() {
        high = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        low = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if (low.isEmpty() && high.isEmpty()) {
            high.offer(num);
        } else {
            high.offer(num);
            low.offer(high.poll());
            if (high.size() < low.size()) {
                high.offer(low.poll());
            }
        }
    }

    public double findMedian() {
        if ((low.size() + high.size()) % 2 == 0) {
            return (low.peek() + high.peek()) / 2d;
        } else {
            return high.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder solution = new MedianFinder();
        solution.addNum(1);
        solution.addNum(2);
        System.err.println("result " + solution.findMedian());
        solution.addNum(3);
        System.err.println("result " + solution.findMedian());
    }
}