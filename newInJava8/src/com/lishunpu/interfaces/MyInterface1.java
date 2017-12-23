package com.lishunpu.interfaces;

/**
 * Created by lishunpu on 2017/5/23.
 */
public interface MyInterface1 {
    default void getName() {
        System.out.println("Lishunpu");
    }

    public static void show() {
        System.out.println("It's a nice feature");
    }
}
