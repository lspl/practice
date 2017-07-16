package singleton;

/**
 * from: http://blog.chenzuhuang.com/archive/13.html
 * @author lishunpu
 * @create 2017-07-16 14:47
 *
 * note: 饿汉式单例
 *      线程安全，延迟加载
 *      对象在类加载的时候就进行加载
 */
public class Singleton2 {
    private static Singleton2 instance = new Singleton2();

    private Singleton2(){}

    public static Singleton2 getInstance() {
        return instance;
    }
}
