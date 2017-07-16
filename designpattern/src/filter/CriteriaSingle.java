package filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lishunpu
 * @create 2017-07-16 20:10
 */
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> singlePersons = new ArrayList<Person>();
        for (Person p : persons) {
            if (p.getMaritalStatus().equalsIgnoreCase("SINGLE")) {
                singlePersons.add(p);
            }
        }
        return singlePersons;
    }
}
