package com.lishunpu.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Created by lishunpu on 2017/5/21.
 */
public class TestLambda1 {
    //无参数，无返回值
    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world.");
            }
        };
        r.run();

        System.out.println("----------------------");
        Runnable r1 = () -> System.out.println("Hello, lambda");
        r1.run();
    }

    //一个参数，无返回值
    @Test
    public void test2() {
        Consumer<String> con = x -> System.out.println(x);
        con.accept("Come on");
    }

    //有两个以上参数，有返回值，Lambda体中有多条语句
    @Test
    public void test3() {
        Comparator<Integer> con = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }

    //有两个以上参数，有返回值，只有一条语句，则大括号和return都可以省略不写
    @Test
    public void test4() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    //自动类型推断，可以不用写数据类型
    public void test5() {
        Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);
    }

    public int operation(int num, MyFun f) {
        return f.getResult(num);
    }

    @Test
    public void test6() {
        System.out.println(operation(10, (x)->x+x));
        System.out.println(operation(100, x->x*x));
    }

}
