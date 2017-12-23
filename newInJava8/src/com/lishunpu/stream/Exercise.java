package com.lishunpu.stream;

import com.lishunpu.lambdaexercise.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by lishunpu on 2017/5/22.
 */

//exercise
public class Exercise {
    //1. 给定一个数字列表，返回一个由每个数字的平方构成的列表
    @Test
    public void square(){
        List<Integer> list = Arrays.asList(1,2,4,5,234,5);
        list.stream().map(x->x*x).forEach(System.out::println);

        Integer[] nums = {1,3,2,4,5,9};
        Arrays.stream(nums).map(x->x*x).forEach(System.out::println);
    }

    //2. 用map和reduce数流中Employee的个数
    List<Employee> emps = Arrays.asList(
            new Employee("张三", 18, 8888, Employee.Status.BUSY),
            new Employee("李四", 43, 7777, Employee.Status.FREE),
            new Employee("王五", 59, 4444, Employee.Status.VOCATION),
            new Employee("赵六", 38, 2421, Employee.Status.FREE),
            new Employee("田七", 24, 5677, Employee.Status.VOCATION)
    );
    @Test
    public void countEmployee() {
        Optional<Integer> op = emps.stream().map(x -> 1).reduce(Integer::sum);
        System.out.println(op.get());
    }
}
