package com.design.flyweight;

/**
 * 享元模式的共享接口信息
 */
public interface Flyweight {
    // 外部状态
    void doOperation(String extrinsicState);
}