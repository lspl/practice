/**
 * 1.4.18
 * 数组的局部最小元素。编写一个程序，给定一个含有N个double值的数组
 * a[], 在其中找到一个局部最小元素：满足a[i]<a[i - 1], 且a[i]<a[i+1]
 * 的索引i。程序在最坏情况下所需的比较次数为 ~ 2lgN.
 *
 * @author lishunpu
 * @create 2017-10-13 16:37
 */

//Solution: 利用二分的思想，满足条件就输出，否则就在较小值侧查找
public class Main_1_4_18 {
    private static double[] randomDoubles(int N) {
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = Math.random() * 100;
        }
        return res;
    }

    private static void print(double[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + " " + nums[i]);
        }
    }

    public static final int N = 20;

    public static void main(String[] args) {
        double[] nums = randomDoubles(N);
        print(nums);

        int low = 0, high = N - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid + 1 <= high && nums[mid] > nums[mid + 1]) {
                low = mid + 1;
            } else if (mid - 1 >= low && nums[mid] > nums[mid - 1]) {
                high = mid - 1;
            } else {
                System.out.println("一种结果：" + mid);
                break;
            }
        }
    }
}
