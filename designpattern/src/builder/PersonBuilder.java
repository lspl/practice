package builder;

/**
 * @author lishunpu
 * @create 2017-07-16 16:27
 */
public interface PersonBuilder {
    void buildHead();
    void buildBody();
    void buildFoot();
    Person buildPerson();
}
