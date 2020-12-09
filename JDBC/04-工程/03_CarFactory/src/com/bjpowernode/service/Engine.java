package com.bjpowernode.service;

/**
 * 2020/4/22
 */
public interface Engine {
    public static final  int width=300;
    public static final  int height=300;
    public void run();
    //1.8---------适配器设计模式----抽象类下岗了
    default public void test(){

        System.out.println("hahaha....");
    }
}
