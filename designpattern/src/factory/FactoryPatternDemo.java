package factory;

/**
 * from: http://www.runoob.com/design-pattern/factory-pattern.html
 * @author lishunpu
 * @create 2017-07-16 10:05
 *
 * note:
 *      Shape表示一个公共接口，Circle, Rectangle, Square是具体的实现类。
 *  ShapeFactory用于将接口和具体的实现类进行关联，也是工厂模式的核心。
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.getShape("circle");
        circle.draw();

        Shape rectangle = factory.getShape("rectangle");
        rectangle.draw();

        Shape square = factory.getShape("square");
        square.draw();
    }
}
