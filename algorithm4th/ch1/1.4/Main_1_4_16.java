import java.util.Arrays;

/**
 * 1.4.16
 *     最接近的一对(一堆)。编写一个程序，给定一个含有N个double值的数组a[], 在
 * 其中找到一对最接近的值：两者之差(绝对值)最小的两个数。程序在最坏情况下所需的
 * 运行时间应该是线性对数级别的
 *
 * @author lishunpu
 * @create 2017-10-13 16:07
 */

//Solution: 先对数组排序，然后逐个扫描并更新
public class Main_1_4_16 {
    private static double[] randomDoubles(int N) {
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = Math.random() * 100;
        }
        return res;
    }

    private static void print(double[] nums) {
        for (int i = 1; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static final int N = 20;

    public static void main(String[] args) {
        double[] nums = randomDoubles(N);
        Arrays.sort(nums);
        print(nums);

        double temp = Double.MAX_VALUE;
        double left = 0, right = 0;

        for (int i = 0; i < N - 1; i++) {
            if (Math.abs(nums[i] - nums[i + 1]) < temp) {
                left = nums[i];
                right = nums[i + 1];
                temp = Math.abs(nums[i] - nums[i + 1]);
            }
        }

        System.out.println("绝对值最小的两个元素为:" + left + " " + right);
    }
}
