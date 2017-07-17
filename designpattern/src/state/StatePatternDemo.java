package state;

/**
 * from: https://www.runoob.com/design-pattern/state-pattern.html
 * @author lishunpu
 * @create 2017-07-17 16:12
 *
 * note: 状态模式
 *      在状态模式中，类的行为基于它的状态而改变
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}
