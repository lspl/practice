package nullobject;

/**
 * @author lishunpu
 * @create 2017-07-17 16:33
 */
public class RealCustomer extends AbstractCustomer{
    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isNull() {
        return false;
    }
}
