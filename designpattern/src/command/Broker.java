package command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lishunpu
 * @create 2017-07-17 13:46
 */
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
