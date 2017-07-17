package decorator;

/**
 * @author lishunpu
 * @create 2017-07-17 8:16
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
