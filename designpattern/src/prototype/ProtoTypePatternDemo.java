package prototype;

/**
 * from: http://www.runoob.com/design-pattern/prototype-pattern.html
 * @author lishunpu
 * @create 2017-07-16 17:24
 *
 * note: 原型模式
 *      用于创建重复的对象，同时又保证性能
 *      这种模式实现了一个原型接口，该接口用于创建当前对象的克隆。当直接创建对象的代价比较大时，则采用这种模式。
 *  例如，一个对象需要在一个高代价的数据库操作之后被创建。我们可以缓存该对象，在下一个请求时返回它的克隆，在需要
 *  的时候更新数据库，以此来减少数据库调用。
 */
public class ProtoTypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape1 = ShapeCache.getShape("1");
        System.out.println("Shape: " + clonedShape1.getType());

        Shape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape: " + clonedShape2.getType());

        Shape clonedShape3 = ShapeCache.getShape("3");
        System.out.println("Shape: " + clonedShape3.getType());
    }
}
