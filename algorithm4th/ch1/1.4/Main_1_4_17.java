/**
 * 1.4.17
 *     最遥远的一对(一维)。编写一个程序，给定一个含有N个double值的数组a[],
 * 在其中找到一对最遥远的值：两者之差(绝对值最大的两个数)。程序在最坏情况下
 * 所需的运行时间应该是线性级别的。
 *
 * @author lishunpu
 * @create 2017-10-13 16:23
 */

//Solution: 一遍扫描，得出数组的最大值和最小值即可
public class Main_1_4_17 {
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
        print(nums);

        double max = nums[0], min = nums[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        System.out.println("两者之差(绝对值)最大的一组为：" + max + " " + min);
    }
}
