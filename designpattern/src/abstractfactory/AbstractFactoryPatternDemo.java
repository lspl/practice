package abstractfactory;

/**
 * from: http://www.runoob.com/design-pattern/abstract-factory-pattern.html
 * @author lishunpu
 * @create 2017-07-16 10:43
 *
 * note:
 *      抽象工厂模式，简单理解，就是用于创建普通工厂模式的工厂
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();
        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        Color red = colorFactory.getColor("RED");
        red.fill();
        Color green = colorFactory.getColor("GREEN");
        green.fill();
        Color blue = colorFactory.getColor("BLUE");
        blue.fill();
    }
}
