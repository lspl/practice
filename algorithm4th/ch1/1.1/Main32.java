/**
 * @author lishunpu
 * @create 2017-09-20 8:18
 */
public class Main32 {
    public static int N = 10;
    public static double l = 0, r = 10;

    public static void main(String[] args) {
        StdDraw.setXscale(-1, 11);
        StdDraw.setYscale(-1, 30);
        StdDraw.line(-1, 0, 11, 0);
        StdDraw.line(0, -1, 0, 30);
        double gap = (r - l) / N;

        for (double i = l; i <= r; i += gap) {
            double t = Math.random() * 30;
            StdDraw.filledRectangle(i + 0.5 * gap, 0.5 * t, 0.5 * gap, 0.5 * t);
        }
    }
}
