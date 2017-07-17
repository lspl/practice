package mediator;

/**
 * from: https://www.runoob.com/design-pattern/mediator-pattern.html
 * @author lishunpu
 * @create 2017-07-17 14:50
 *
 * note: 中介者模式
 *      用于降低多个对象和类之间的通信复杂性。需要提供一个中介类，处理不同类之间的通信，并支持松耦合。
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
