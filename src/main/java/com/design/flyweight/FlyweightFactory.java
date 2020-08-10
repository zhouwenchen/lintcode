package com.design.flyweight;

import java.util.HashMap;

public class FlyweightFactory {

    private HashMap<String, Flyweight> flyweights = new HashMap<>();

    /**
     * 通过 intrinsicState 获取到实例，如果不存在，就创建一个。类似于线程池的实现方式
     * @param intrinsicState
     * @return
     */
    Flyweight getFlyweight(String intrinsicState) {
        if (!flyweights.containsKey(intrinsicState)) {
            Flyweight flyweight = new ConcreteFlyweight(intrinsicState);
            flyweights.put(intrinsicState, flyweight);
        }
        return flyweights.get(intrinsicState);
    }
}