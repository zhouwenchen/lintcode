package com.offer.test;

/**  
 * “懒汉式” 单例模式的加载方式
 * 每次访问时都要同步，会影响性能，且消耗更多的资源，这是懒汉式单例的缺点。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月23日 上午10:50:57 
 */
public class SingletonLazy {
	// 1.创建私有的构造函数，防止外部的初始化
	private SingletonLazy(){}
	// 2.私有化成员对象为null 
	private static volatile SingletonLazy instance = null;  // volatile 保证  instance 在多线程之间可以保持同步
	
	// 3.提供一个公共的获取成员对象的方法
	public static synchronized SingletonLazy getInstance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}
}