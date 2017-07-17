package observer;

/**
 * @author lishunpu
 * @create 2017-07-17 15:29
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
