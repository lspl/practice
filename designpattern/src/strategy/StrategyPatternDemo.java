package strategy;

/**
 * from: https://www.runoob.com/design-pattern/strategy-pattern.html
 * @author lishunpu
 * @create 2017-07-17 17:13
 *
 * note: 策略模式
 *      在运行时更改类的行为或算法
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
