package com.cmentech.task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorPool {

	//私有构造方法
	private ExecutorPool() {
		
	}
	
	private ExecutorService service = null;

	//延迟加载
	private enum EnumHolder {
		
		INSTANCE;
		
		private ExecutorPool instance = null;
		
        EnumHolder(){
            instance = new ExecutorPool();
            instance.service = Executors.newFixedThreadPool(2);
        }
		
        private ExecutorPool getInstance(){
            return instance;
        }
        
	}//懒加载
	
	public static ExecutorPool getInstance() {
		return EnumHolder.INSTANCE.instance;
	}
	
	public static <T> Future<T> submit(Callable<T> task) {
	
		return EnumHolder.INSTANCE.getInstance().service.submit(task);
	
	}
	
	public static <T> Future<T> submit(Runnable task, T result) {
		
		return EnumHolder.INSTANCE.getInstance().service.submit(task, result);
		
	}
	
	public static Future<?> submit(Runnable task) {
		
		return EnumHolder.INSTANCE.getInstance().service.submit(task);
		
	}
	
	public static void execute(Runnable command) {
		EnumHolder.INSTANCE.getInstance().service.execute(command);
	}
	
	public ExecutorService getService() {
		return this.service;
	}
	
	public static void shutdown() {
		EnumHolder.INSTANCE.getInstance().service.shutdown();
	}
	
	public static void shutdownNow() {
		EnumHolder.INSTANCE.getInstance().service.shutdown();
	}
}
