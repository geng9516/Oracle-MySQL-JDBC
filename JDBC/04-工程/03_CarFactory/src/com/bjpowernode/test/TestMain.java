package com.bjpowernode.test;

import com.bjpowernode.entity.Car;
import com.bjpowernode.service.Engine;
import com.bjpowernode.serviceImpl.SprotEngine;
import com.bjpowernode.serviceImpl.SuvEngine;

/**
 * 2020/4/22
 */
public class TestMain {

    public static void main(String[] args) {


       //用户需要一个具有越野特征汽车
       //Engine engine= new SuvEngine();

        //用户需求变更，要求得到一辆具有运动特征汽车
        Engine engine = new SprotEngine();
       Car car = new Car(engine);
       car.run();
       engine.test();



    }
}
