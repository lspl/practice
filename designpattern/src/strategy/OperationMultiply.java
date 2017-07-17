package strategy;

/**
 * @author lishunpu
 * @create 2017-07-17 17:04
 */
public class OperationMultiply implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
