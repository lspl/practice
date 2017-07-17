package flyweight;

/**
 * from: https://www.runoob.com/design-pattern/flyweight-pattern.html
 * @author lishunpu
 * @create 2017-07-17 9:14
 *
 * note: 享元模式
 *      用于减少创建对象的数量，从而减少内存和提高性能
 *      具体实施，就是重复利用已有的能够实现功能的对象
 */
public class FlyweightPatternDemo {
    private static final String colors[] = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}
