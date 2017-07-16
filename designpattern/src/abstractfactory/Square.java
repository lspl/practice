package abstractfactory;

/**
 * @author lishunpu
 * @create 2017-07-16 10:02
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
