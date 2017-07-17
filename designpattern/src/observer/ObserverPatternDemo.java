package observer;

/**
 * from: https://www.runoob.com/design-pattern/observer-pattern.html
 * @author lishunpu
 * @create 2017-07-17 15:47
 *
 * note: 观察者模式
 *      当对象间存在一对多关系时，使用观察者模式(Observer Pattern)。
 *      比如，当一个对象被修改时，则会自动通知它的依赖对象。
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
