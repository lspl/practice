public class Main27 {
    public static double[][] m;
    public static double binomial(int N, int k, double p) {
        if (N == 0) {
            return 0.0;
        }
        if (k == 0) {
            return Math.pow(1 - p, N);
        }
        if (N == 1 && k == 1) {
            return p;
        }
        if (k == 1) {
            return Math.pow(1 - p, N);
        }

        return (1.0 - p) * m[N - 1][k] + p * m[N - 1][k - 1];
    }

    public static void main(String[] args) {
        int N = 20, k = 10;
        m = new double[N + 1][k + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < k + 1 && j <= i; j++) {
                m[i][j] = binomial(i, j, 0.25);
            }
        }
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                System.out.printf("%-10f  ", m[i][j]);
            }
            System.out.println();
        }
        System.out.println(m[10][5]);
    }
}


