package filter;

import java.util.List;

/**
 * @author lishunpu
 * @create 2017-07-16 20:13
 */
public class AndCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCirteria;

    public AndCriteria(Criteria criteria, Criteria otherCirteria) {
        this.criteria = criteria;
        this.otherCirteria = otherCirteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);
        return otherCirteria.meetCriteria(firstCriteriaPersons);
    }
}
