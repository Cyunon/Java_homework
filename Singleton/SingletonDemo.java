package Singleton;

public class SingletonDemo {
	private static class Singleton{
		private static SingletonDemo instance = new SingletonDemo();
	}
	
	private SingletonDemo() {
		System.out.println("Singleton has loaded");
	}
	
	public static SingletonDemo getInstance() {
		return Singleton.instance;
	}

}
