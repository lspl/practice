package singleton;

/**
 * from: http://blog.chenzuhuang.com/archive/13.html
 * @author lishunpu
 * @create 2017-07-16 15:10
 *
 * note: 静态内部类
 *      线程安全，延迟加载
 */
public class Singleton3 {
    private static class SingletonHolder {
        private static Singleton3 instance = new Singleton3();
    }
    private Singleton3(){}
    private static Singleton3 getInstance() {
        return SingletonHolder.instance;
    }
}
