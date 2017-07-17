package memento;

/**
 * @author lishunpu
 * @create 2017-07-17 15:01
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
