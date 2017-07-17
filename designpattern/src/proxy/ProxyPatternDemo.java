package proxy;

/**
 * from: https://www.runoob.com/design-pattern/proxy-pattern.html
 * @author lishunpu
 * @create 2017-07-17 9:58
 *
 * note： 代理模式
 *      为其它对象提供一种代理以控制对这个对象的访问
 *
 * 使用场景：
 *      远程代理; 虚拟代理; Copy-on-Write代理; 保护(Protect or Access)代理; Cache代理; 防火墙(Firewall)代理
 *      同步化(synchronization)代理; 智能引用(smart reference)代理
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.png");

        image.display();
        System.out.println();
        image.display();
    }
}
