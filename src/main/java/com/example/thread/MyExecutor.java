package com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyExecutor {

	public void fun() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		cachedThreadPool.execute(new Runnable() {
			public void run() {
				System.out.println("不知道什么时候执行异步调用呀");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) throws Exception {
		MyExecutor myExecutor = new MyExecutor();

		myExecutor.fun();
		System.out.println("main结束了");
	}
}