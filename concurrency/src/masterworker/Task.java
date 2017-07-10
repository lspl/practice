package masterworker;

/**
 * @author lishunpu
 * @create 2017-07-10 14:23
 */
public class Task {
    private Integer id;
    private String name;
    private Integer price;

    public Task(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

}
