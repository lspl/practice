package com.lishunpu.lambdaexercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lishunpu on 2017/5/21.
 */
public class Test {
    List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 8888),
            new Employee("李四", 43, 7777),
            new Employee("王五", 23, 4444),
            new Employee("赵六", 23, 2421),
            new Employee("田七", 24, 5677)
    );

    @org.junit.Test
    public void test1() {
        Collections.sort(emps, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        for(Employee e : emps) {
            System.out.println(e);
        }

    }
}
