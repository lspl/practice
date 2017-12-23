package com.lishunpu.lambdaexercise;

/**
 * Created by lishunpu on 2017/5/21.
 */
@FunctionalInterface
public interface MyFun3<T,R> {
    public R get(T t1, T t2);
}
