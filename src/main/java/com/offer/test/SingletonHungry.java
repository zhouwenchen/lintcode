package com.offer.test;

/**  
 * “饿汉式” 单例模式
 * 这种模式的特点在于一旦创建或是加载，就创建一个单例。保证在调用 getInstance方法之前，就已经存在了  instance 对象
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月23日 上午10:43:33 
 */
public class SingletonHungry {
	// 1.私有化构造函数
	private SingletonHungry() {}
	
	// 2.私有化创建对象
	private static SingletonHungry instance = new SingletonHungry();
	
	// 提供一个公共的方法，用于调用者调用
	public static SingletonHungry getInstance(){
		return instance;
	}
}