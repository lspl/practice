package com.lishunpu.optional;

import com.lishunpu.lambdaexercise.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by lishunpu on 2017/5/22.
 */
public class TestOptional {
    /*
    Optional.of(T t) : 创建一个 Optional 实例
    Optional.empty() : 创建一个空的 Optional 实例
    Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
    isPresent() : 判断是否包含值
    orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
    orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
    map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
    flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
    */

    //如果Optional.of()括号中为一个空对象，则会出现空指针异常，异常位置明显，可防止后续出现更严重的问题
    @Test
    public void test1() {
        //Optional<Employee> op = Optional.of(new Employee());
        Optional<Employee> op = Optional.of(null);
        System.out.println(op.get());
    }

    //Optional.empty() : 创建一个空的 Optional 实例
    @Test
    public void test2() {
        Optional<Employee> op = Optional.empty();
        System.out.println(op.get());
    }

    //Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例.
    //相当于结合了Optional.of(T t)和Optional.empty(). 其源码也是那么做的
    @Test
    public void test3() {
        Optional<Employee> op = Optional.ofNullable(null);
//        Optional<Employee> op = Optional.ofNullable(new Employee());

//        if(op.isPresent()) {
//            System.out.println(op.get());
//        } else {
//            System.out.println("Empty value");
//        }

//        Employee emp = op.orElse(new Employee("zhangsan", 23, 8888, Employee.Status.FREE)); //如果op为空
//        System.out.println(emp);

        Employee emp1 = op.orElseGet(() -> new Employee());
        System.out.println(emp1);
    }

    @Test
    public void test4() {
        Optional<Employee> op = Optional.ofNullable(new Employee("zhangsan", 23, 8888, Employee.Status.FREE));
//        Optional<String> str = op.map((e) -> e.getName());
//        System.out.println(str.get());

        //flatMap: 映射的结果也必须是一个Optional
        Optional<String> str2 = op.flatMap((e)->Optional.of(e.getName()));
        System.out.println(str2.get());
    }
}
