package com.lishunpu.interfaces;

/**
 * Created by lishunpu on 2017/5/23.
 */
public interface MyInterface2 {
    default void getName() {
        System.out.println("李顺谱");
    }
}
