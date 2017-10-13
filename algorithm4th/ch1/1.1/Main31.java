import java.awt.*;

/**
 * @author lishunpu
 * @create 2017-09-19 20:44
 */
public class Main31 {
    public static int N = 20;
    public static double p = 0.25;
    public static void main(String[] args) {
        StdDraw.setXscale(-10, 10);
        StdDraw.setYscale(-10, 10);

        double _x = 3, _y = 4, r = 5;
        StdDraw.circle(_x, _y, r);
        StdDraw.line(-10, 0, 10, 0);
        StdDraw.line(0, -10, 0, 10);
        StdDraw.setPenRadius(0.01);
        StdDraw.point(_x, _y);
        StdDraw.setPenColor(Color.RED);

        Point[] points = new Point[N];
        double t = (2 * Math.PI / 360) * 360 / N;
        for (int i = 0; i < N; i++) {
            points[i] = new Point(_x + r * Math.cos(t * i), _y + r * Math.sin(t * i));
            StdDraw.point(points[i].x, points[i].y);
        }

        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(Color.GRAY);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (Math.random() < p) {
                    StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
                }
            }
        }
    }
}

class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
