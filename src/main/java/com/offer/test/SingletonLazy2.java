package com.offer.test;

/**  
 * “懒汉式” 单例模式的加载方式
 * 每次访问时都要同步，会影响性能，且消耗更多的资源，这是懒汉式单例的缺点。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月23日 上午10:50:57 
 */
public class 	SingletonLazy2 {
	// 1.创建私有的构造函数，防止外部的初始化
	private SingletonLazy2(){}
	// 2.私有化成员对象为null 
	private static volatile SingletonLazy2 instance = null;  // volatile 保证  instance 在多线程之间可以保持同步
	
	// 3.提供一个公共的获取成员对象的方法
	public static SingletonLazy2 getInstance() { // 不使用同步方法，而是用同步代码块的方式，提高效率
		
		if (instance == null) { // 当对象没有创建成功，多线程都会进入到此为止，都会去创建对象
			synchronized (SingletonLazy2.class) { // 多线程在获取对象的时候进行阻塞。但是仅有一个线程可以获取到锁对象，当某一个线程获取到锁对象，并成功创建实例对象返回，后序的线程都不会创建对象了
				if (instance == null) {
					instance = new SingletonLazy2();
				}
			}
		}
		return instance;
	}
}