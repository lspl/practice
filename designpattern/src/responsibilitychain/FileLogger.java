package responsibilitychain;

/**
 * @author lishunpu
 * @create 2017-07-17 10:25
 */
public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
