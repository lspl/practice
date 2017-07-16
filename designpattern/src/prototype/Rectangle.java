package prototype;

/**
 * @author lishunpu
 * @create 2017-07-16 17:17
 */
public class Rectangle extends Shape{

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
