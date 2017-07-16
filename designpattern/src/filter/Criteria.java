package filter;

import java.util.List;

/**
 * @author lishunpu
 * @create 2017-07-16 20:05
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);

}
