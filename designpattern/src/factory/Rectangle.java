package factory;

/**
 * @author lishunpu
 * @create 2017-07-16 9:58
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
