package singleton;

/**
 * from: http://blog.chenzuhuang.com/archive/13.html
 * @author lishunpu
 * @create 2017-07-16 14:32
 *
 * note: 懒汉式单例
 *      线程不安全，在getInstance方法上加上synchronized即可变为线程安全的
 *      对象在首次使用时才进行加载
 */
public class Singleton1 {
    private static Singleton1 instance = null;
    private Singleton1(){}

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
