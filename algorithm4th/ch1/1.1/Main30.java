/**
 * @author lishunpu
 * @create 2017-09-19 20:18
 */
public class Main30 {
    public static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        if (m < n) {
            int t = m;
            m = n;
            n = t;
        }
        return gcd(n, m % n);
    }
    public static final int N = 50;
    public static void main(String[] args) {
        boolean[][] a = new boolean[N + 1][N + 1];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                a[i][j] = gcd(i, j) == 1;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
