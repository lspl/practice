package nullobject;

/**
 * from: https://www.runoob.com/design-pattern/null-object-pattern.html
 * @author lishunpu
 * @create 2017-07-17 16:38
 *
 * note: 空对象模式
 *      在空对象模式中，一个空对象取代null对象实例的检查。null对象不是检查空值，
 *   而是反映一个不做任何动作的关系。这样的null对象也可以在数据不可用的时候提供
 *   默认的行为。
 */
public class NullPatternDemo {
    public static void main(String[] args) {
        AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

        System.out.println("Customers");
        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }
}
