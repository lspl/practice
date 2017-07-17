package command;

/**
 * from: https://www.runoob.com/design-pattern/command-pattern.html
 * @author lishunpu
 * @create 2017-07-17 13:51
 *
 * note: 命令模式
 *      请求以命令的形式包裹在对象中，并传给调用对象。调用对象寻找可以处理该命令的合适的对象，并把该
 *   命令传给相应的对象，该对象执行命令
 */
public class CommandPatternDemo {
    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
