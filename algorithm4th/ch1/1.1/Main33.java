import org.junit.Test;

/**
 * @author lishunpu
 * @create 2017-09-20 9:21
 */
public class Main33 {
    // 向量点乘
    static double dot(double[] x, double[] y){
        if (x.length != y.length) {
            throw new RuntimeException("向量长度不同");
        }
        double result = 0.0;
        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }
        return result;
    }

    // 矩阵和矩阵的乘积
    static double[][] mult1(double[][] a, double[][] b) {
        if(a[0].length != b.length) {
            throw new RuntimeException("第一个矩阵列数和第二个矩阵的行数不相等");
        }
        double[][] m = new double[a.length][b[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                double[] t = new double[b.length];
                for (int k = 0; k < t.length; k++) {
                    t[k] = b[k][j];
                }
                m[i][j] = dot(a[i], t);
            }
        }
        return m;
    }

    // 矩阵转置
    static double[][] transpose(double[][] a) {
        double[][] m = new double[a[0].length][a.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = a[j][i];
            }
        }
        return m;
    }

    // 矩阵和向量相乘
    static double[] mult2(double[][] a, double[] x) {
        if (a[0].length != x.length) {
            throw new RuntimeException("矩阵的列数和向量的行数不等,无法相乘");
        }
        double[] m = new double[a.length];
        for (int i = 0; i < m.length; i++) {
            m[i] = dot(a[i], x);
        }
        return m;
    }

    // 向量和矩阵相乘
    static double[] mult3(double[] y, double[][] a) {
        if (y.length != a.length) {
            throw new RuntimeException("向量的长度和矩阵的行数不等,无法相乘");
        }
        double[] m = new double[a[0].length];
        for (int i = 0; i < m.length; i++) {
            double[] t = new double[a.length];
            for (int j = 0; j < t.length; j++) {
                t[j] = a[j][i];
            }
            m[i] = dot(y, t);
        }
        return m;
    }

    // 打印二维矩阵
    public static void print(double[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.printf("%5f  ", a[i][j]);
            }
            System.out.println();
        }
    }

    // 打印一维矩阵
    public static void print(double[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void testDot() {
        double[] a = {1, 3, 5};
        double[] b = {2, 4, 3};
        System.out.println(dot(a, b));
    }

    @Test
    public void testMult1() {
        double[][] a = {
                {1, 3, 5},
                {2, 4, 6}
        };
        double[][] b = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        print(mult1(a, b));
    }

    @Test
    public void testTranspose() {
        double[][] a = {
                {1, 3, 5},
                {2, 4, 6}
        };
        print(transpose(a));
    }

    @Test
    public void testMult2() {
        double[][] a = {
                {1, 3, 5},
                {2, 4, 6}
        };
        double[] x = {1, 2, 3};
        print(mult2(a, x));
    }

    @Test
    public void testMult3() {
        double[] y = {1, 2, 3};
        double[][] a = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        print(mult3(y, a));
    }
}
