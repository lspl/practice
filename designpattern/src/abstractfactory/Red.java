package abstractfactory;

/**
 * @author lishunpu
 * @create 2017-07-16 10:33
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
