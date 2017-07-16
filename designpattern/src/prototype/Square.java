package prototype;

/**
 * @author lishunpu
 * @create 2017-07-16 17:18
 */
public class Square extends Shape {
    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
