package com.bjpowernode.entity;

import com.bjpowernode.service.Engine;

/**
 * 2020/4/22
 */
public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void run(){
        engine.run();
    }
}
