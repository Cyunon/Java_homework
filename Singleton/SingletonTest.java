package Singleton;

public class SingletonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonDemo sgl1 = SingletonDemo.getInstance();
		if(sgl1 != null) {
			System.out.println("sgl �ǿ�");
		}
		
		SingletonDemo sgl2 = SingletonDemo.getInstance();
		if(sgl1 == sgl2) {
			System.out.println("sgl1 �� sgl2 ���");
		}

	}

}
