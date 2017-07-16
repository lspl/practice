package bridge;

/**
 * @author lishunpu
 * @create 2017-07-16 19:20
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: " + radius +", x: " + x +", "+ y +"]");
    }
}
