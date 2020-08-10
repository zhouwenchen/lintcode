package com.design.mediator;

/**
 * 中介者模式实现的方式
 */
public abstract class Colleague {
    public abstract void onEvent(Mediator mediator);
}