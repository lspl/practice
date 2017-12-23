package com.lishunpu.interfaces;

/**
 * Created by lishunpu on 2017/5/23.
 */
public class SubClass implements MyInterface1, MyInterface2{
    public void getName() {
        MyInterface2.super.getName();
    }
}
