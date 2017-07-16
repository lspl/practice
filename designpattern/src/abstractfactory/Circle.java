package abstractfactory;

/**
 * @author lishunpu
 * @create 2017-07-16 10:02
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
