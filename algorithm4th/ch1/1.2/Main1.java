import java.awt.*;
import java.util.ArrayList;

/**
 * @author lishunpu
 * @create 2017-09-20 14:22
 */
public class Main1 {
    public static void main(String[] args) {
        double minDistance = 150;
        StdDraw.setXscale(-1, 11);
        StdDraw.setYscale(-1, 11);
        StdDraw.line(-1, 0, 11, 0);
        StdDraw.line(0, -1, 0, 11);
        StdDraw.setPenColor(Color.RED);
        StdDraw.setPenRadius(.005);
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < 100; i++) {
            double x = 10 * Math.random();
            double y = 10 * Math.random();
            points.add(new Point(x, y));
            StdDraw.point(x, y);
        }
        int t1 = 0, t2 = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            for (int j = i + 1; j < points.size(); j++) {
                Point p2 = points.get(j);
                double t = (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
                if (minDistance > t) {
                    t1 = i;
                    t2 = j;
                    minDistance = t;
                }
            }
        }
        StdDraw.setPenColor(Color.GREEN); //将距离最近的两个点用绿色进行标识
        StdDraw.point(points.get(t1).x, points.get(t1).y);
        StdDraw.point(points.get(t2).x, points.get(t2).y);
        System.out.println(Math.sqrt(minDistance));
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
