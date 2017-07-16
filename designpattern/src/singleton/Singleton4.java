package singleton;

/**
 * from: http://www.runoob.com/design-pattern/singleton-pattern.html
 * @author lishunpu
 * @create 2017-07-16 15:16
 *
 * note: DCL(双检查锁）
 */
public class Singleton4 {
    private volatile static Singleton4 instance = null;
    private Singleton4() {}
    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
