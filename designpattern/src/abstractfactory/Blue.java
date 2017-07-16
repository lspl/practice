package abstractfactory;

/**
 * @author lishunpu
 * @create 2017-07-16 10:35
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
