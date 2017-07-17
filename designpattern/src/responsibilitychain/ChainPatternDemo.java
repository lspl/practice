package responsibilitychain;

/**
 * from: https://www.runoob.com/design-pattern/chain-of-responsibility-pattern.html
 * @author lishunpu
 * @create 2017-07-17 10:32
 *
 * note: 责任链模式
 *      避免请求发送者与接收者耦合在一起，让多个对象都有可能接受请求，将这些请求连接成一条链，并且沿着
 *   这条链传递请求，直到有对象处理它为止
 */
public class ChainPatternDemo {
    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information");
    }
}
