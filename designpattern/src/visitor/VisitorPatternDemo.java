package visitor;

/**
 * from: https://www.runoob.com/design-pattern/visitor-pattern.html
 * @author lishunpu
 * @create 2017-07-17 19:09
 *
 * note: 访问者模式
 *      使用访问者类，改变元素类的执行算法
 *      具体在下例中，则是Computer, ComputerPartVisitor演示访问者模式的使用
 */
public class VisitorPatternDemo {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
