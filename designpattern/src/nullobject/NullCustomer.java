package nullobject;

/**
 * @author lishunpu
 * @create 2017-07-17 16:34
 */
public class NullCustomer extends AbstractCustomer {
    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
