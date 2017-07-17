package responsibilitychain;

/**
 * @author lishunpu
 * @create 2017-07-17 10:23
 */
public class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
