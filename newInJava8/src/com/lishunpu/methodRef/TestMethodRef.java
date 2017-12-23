package com.lishunpu.methodRef;

import com.lishunpu.lambdaexercise.Employee;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;

/**
 * Created by lishunpu on 2017/5/21.
 * 方法引用注意事项
 * 1. Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 * 2. 若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method
 *
 * 构造器引用：ClassName:new
 * 注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
 *
 */
public class TestMethodRef {
    //对象::实例方法名
    @Test
    public void test1() {
        Consumer<String> con = System.out::println;
        con.accept("abcds");

        Employee e = new Employee("张三", 18, 8998);
        //Supplier<Integer> s = () -> e.getSalary();
        Supplier<Integer> s = e::getSalary;
        System.out.println(s.get());
    }

    //类::静态方法名
    @Test
    public void test2() {
        //Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        Comparator<Integer> com = Integer::compare;

    }

    //类::实例方法名
    @Test
    public void test4() {
        //前提：第一个参数是实例方法的调用者，第二个参数是实例方法的参数时，才能使用类::实例方法名
        //BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        BiPredicate<String, String> bp = String::equals;
        System.out.println(bp.test("abc", "abc"));
    }

    //构造器引用
    @Test
    public void test5() {
        Supplier<Employee> t = () -> new Employee();
        System.out.println(t.get());

        Supplier<Employee> t1 = Employee::new;
        System.out.println(t1.get());

        Function<Integer, Employee> f = Employee::new;
        Employee e = f.apply(3);
        System.out.println(e);

        BiFunction<Integer, Integer, Employee> f1 = Employee::new;
        Employee e1 = f1.apply(34,4000);
        System.out.println(e1);

        BiFunction<String, Integer, Employee> f2 = Employee::new;
        Employee e2 = f2.apply("李顺谱",20000);
        System.out.println(e2);
    }

    //数组引用
    @Test
    public void test6() {
        Function<Integer, String[]> f = x -> new String[x];
        System.out.println(f.apply(10).length);

        Function<Integer, String[]> f1 = String[]::new;
        System.out.println(f1.apply(12).length);
    }
}
