package decorator;

/**
 * from: https://www.runoob.com/design-pattern/decorator-pattern.html
 * @author lishunpu
 * @create 2017-07-17 8:24
 *
 * note: 装饰器模式
 *      在不改变现有对象结构的基础上，添加功能
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
