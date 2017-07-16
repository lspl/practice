package abstractfactory;

/**
 * @author lishunpu
 * @create 2017-07-16 10:35
 */
public abstract class AbstractFactory  {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}
