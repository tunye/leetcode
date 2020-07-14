//https://leetcode-cn.com/problems/kth-largest-element-in-an-array
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        // nlogn o(1) 不稳定
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        // n^2 o(1) 稳定
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            boolean swap = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    swap = true;
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
            if (!swap) {
                break;
            }
        }
        return nums[k - 1];
    }

    public int findKthLargest3(int[] num, int k) {
        // n+d o(d) 稳定
        if (num.length < 2)
            return num[k - 1];

        int length = num.length;
        int min = num[0];
        int max = num[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(num[i], max);
            min = Math.min(num[i], min);
        }
        int d = max - min + 1;
        int[] temp = new int[d];
        // 计数
        for (int value : num) {
            temp[max - value]++;
        }
        int pointer = 0;
        for (int i = 0; i < d; i++) {
            for (int j = temp[i]; j > 0; j--) {
                num[pointer++] = max - i;
            }
        }
        return num[k - 1];
    }

    public int findKthLargest4(int[] num, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int value : num) {
            queue.offer(value);
        }
        int result = 0;
        for (int i = 0; i < num.length - k + 1; i++) {
            result = queue.poll();
        }
        return result;
    }

    public int findKthLargest5(int[] num, int k) {
        QuickSort(num);
        return num[num.length - k];
    }

    private int partion(int[] array, int low, int high) {//合并排序部分
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                --high;
            }
            if (low >= high) {
                break;
            } else {
                array[low] = array[high];//交换小值去前面
            }

            while (low < high && array[low] <= tmp) {
                ++low;
            }
            if (low >= high) {
                break;
            } else {
                array[high] = array[low];//交换大值去后面
            }
        }
        array[low] = tmp;//枢值归位
        return low;
    }

    private void QuickSort(int[] array) {
        int[] stack = new int[array.length];//利用一个栈来保存每次需要排序的左右端点信息
        int top = 0;
        int low = 0;
        int high = array.length - 1;
        int par = partion(array, low, high);//得到第一个划分点
        if (par > low + 1) {//左端点是否存在
            stack[top++] = low;
            stack[top++] = par - 1;
        }
        if (par < high - 1) {//左端点是否存在
            stack[top++] = par + 1;
            stack[top++] = high;
        }
        while (top > 0) {//过程同上，用循环代替递归
            high = stack[--top];
            low = stack[--top];
            par = partion(array, low, high);
            if (par > low + 1) {
                stack[top++] = low;
                stack[top++] = par - 1;
            }
            if (par < high - 1) {
                stack[top++] = par + 1;
                stack[top++] = high;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.err.println("result " + solution.findKthLargest5(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}