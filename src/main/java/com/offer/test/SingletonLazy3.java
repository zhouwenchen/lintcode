package com.offer.test;

/**
 * “懒汉式” 单例模式的加载方式
 * 优化于double checke的形式
 *
 * @author zhouwenchen@021.com
 * @date 2020年4月11日 上午14:00:00
 */
public class SingletonLazy3 {
	// 1.创建私有的构造函数，防止外部的初始化
	private SingletonLazy3(){}
	// 2.私有化成员对象为null 
	private static class InstanceHolder{
		private final static SingletonLazy3 instance = new SingletonLazy3();
	}
	// 3.提供公共的访问实例的方法
	public static SingletonLazy3 getInstance() {
	    return InstanceHolder.instance;
	}
}