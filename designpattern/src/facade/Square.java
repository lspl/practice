package facade;

/**
 * @author lishunpu
 * @create 2017-07-17 8:43
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
