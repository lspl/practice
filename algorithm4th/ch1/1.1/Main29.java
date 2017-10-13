/**
 * @author lishunpu
 * @create 2017-09-19 20:18
 */
public class Main29 {
    public static int count = 0; //与key相等的数的个数
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                for (int i = lo; i <= hi; i++) {
                    if (a[i] == key) {  //相等
                        count++;
                    }
                }
                for (int j = mid; j > lo; j--) {
                    if (a[j] < key) {
                        return j + 1;
                    }
                }
                return 0;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
