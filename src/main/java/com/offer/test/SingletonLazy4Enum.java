package com.offer.test;

/**
 * “懒汉式” 单例模式的加载方式
 * 使用Enum 实现的单例
 *
 * @author zhouwenchen@021.com
 * @date 2020年4月11日 上午14:00:00
 */
public class SingletonLazy4Enum {
	// 1.创建私有的构造函数，防止外部的初始化
	private SingletonLazy4Enum(){}
	// 创建枚举
	private enum Singleton{
		INSTANCE;
		private final SingletonLazy4Enum instance;
		Singleton(){
			instance = new SingletonLazy4Enum();
		}
		public SingletonLazy4Enum getInstance(){
			return this.instance;
		}
	}
	public static SingletonLazy4Enum getInstance() {
	    return Singleton.INSTANCE.getInstance();
	}
}