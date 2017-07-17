package facade;

/**
 * from：https://www.runoob.com/design-pattern/facade-pattern.html
 * @author lishunpu
 * @create 2017-07-17 8:48
 *
 * note: 外观模式
 *      向现有的系统添加一个接口，来隐藏系统的复杂性
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
