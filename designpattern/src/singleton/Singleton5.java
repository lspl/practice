package singleton;

/**
 * from： http://www.runoob.com/design-pattern/singleton-pattern.html
 * @author lishunpu
 * @create 2017-07-16 15:20
 *
 * note: 枚举
 *      三个好处：实例的创建线程安全，保证单例；防止被反射创建多个实例
 */
public enum Singleton5 {
    INSTANCE;
    public void whateverMethod() {
    }
}
