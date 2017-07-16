package abstractfactory;

/**
 * @author lishunpu
 * @create 2017-07-16 10:34
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill method.");
    }
}
