package com.lishunpu.View;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by lishunpu on 2017/5/22.
 */
public class Review {
    public void consumer(int x, Consumer<Integer> c) {
        c.accept(x);
    }

    @Test
    public void testConsumer() {
        consumer(3, (x) -> System.out.println(x + 3));
    }

    public int supplier(Supplier<Integer> s) {
        return s.get();
    }

    @Test
    public void testSupplier() {
        System.out.println(supplier(()->(int)(100 * Math.random())));
    }

    public int function(int x, Function<Integer, Integer> f) {
        return f.apply(x);
    }

    @Test
    public void testFunction() {
        System.out.println(function(3, x -> x * 4));
    }

    public boolean testPredict(int x, Predicate<Integer> t) {
        return t.test(x);
    }
    @Test
    public void testPredicate() {
        System.out.println(testPredict(100, x -> x > 4));
    }
}
