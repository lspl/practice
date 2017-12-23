package com.lishunpu.corefunctioninterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by lishunpu on 2017/5/21.
 */
public class Test {
    //Consumer<T>: 消费型接口  void accept(T t), 有一个参数
    public void consume(int num, Consumer<Integer> c) {
        c.accept(num);
    }

    @org.junit.Test
    public void testComsumer1() {
        consume(1000, x -> System.out.println("总共花了" + x + "元"));
    }

    //Supplier<T>: 供给型接口 T get()， 没有参数
    public List<Integer> supplier(int num, Supplier<Integer> s) {
        List<Integer> list = new ArrayList<>();
        while (num-- > 0) {
            list.add(s.get());
        }
        return list;
    }

    @org.junit.Test
    public void testSupplier() {
        List<Integer> list = supplier(10, () -> (int)(Math.random() * 100));
        list.forEach(System.out::println);
    }

    //Function<T, R>: 函数型接口， 参数为T, 返回值为R  R function(T t)
    public int function(int x, Function<Integer, Integer> f) {
        return f.apply(x);
    }

    @org.junit.Test
    public void testFunction() {
        System.out.println(function(3, x -> x * 2));
    }

    //Predicate<T>: 断定型接口， 返回值为boolean   boolean test(T t)
    public boolean predicate(int t, Predicate<Integer> p) {
        return p.test(t);
    }

    @org.junit.Test
    public void testPredicate() {
        System.out.println(predicate(3, x -> x > 10));
    }
}
