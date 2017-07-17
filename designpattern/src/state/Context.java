package state;

/**
 * @author lishunpu
 * @create 2017-07-17 16:08
 */
public class Context {
    private State state;

    public Context() {
        state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
