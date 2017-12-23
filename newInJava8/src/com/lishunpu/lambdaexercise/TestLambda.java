package com.lishunpu.lambdaexercise;

/**
 * Created by lishunpu on 2017/5/21.
 */
public class TestLambda {
    public String toUpper(String str, MyFun2 f) {
        return f.getValue(str.toUpperCase());
    }

    //将str理解为toUpper()的结果
    @org.junit.Test
    public void test() {
        System.out.println(toUpper("abafdqr", str -> str.substring(2,4)));
    }

    public long get(long l1, long l2, MyFun3<Long, Long> f) {
        return f.get(l1, l2);
    }
    @org.junit.Test
    public void test2() {
        System.out.println(get(100, 102, (x,y) -> x + y));
        System.out.println(get(100, 102, (x,y) -> x * y));
    }
}
