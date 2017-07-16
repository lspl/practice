package bridge;

/**
 * from: http://www.runoob.com/design-pattern/bridge-pattern.html
 * @author lishunpu
 * @create 2017-07-16 19:23
 *
 * note: 桥接模式
 *      将抽象部分与实现部分分离，使得二者可以独立变化
 *      典型应用：jdbc
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
