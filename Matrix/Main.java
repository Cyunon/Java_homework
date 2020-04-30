package Matrix;

public class Main {

	public static void main(String[] args) {
		double[][] A;
		double[][] B;
		double[][] C;
		int M = 1000;
		int K = 1000;
		int N = 1000;
		A = new MatrixGenerator(M,K).getMatrix();
		B = new MatrixGenerator(K,N).getMatrix();
		Driver dri = new Driver(M, N, K, 2, A, B);   //使用2线程
		dri.Serial();
		dri.Parallel();
		
		Driver dri2 = new Driver(M, N, K, 4, A, B);   //使用4线程
		dri2.Serial();
		dri2.Parallel();
		
		Driver dri3 = new Driver(M, N, K, 6, A, B);   //使用6线程
		dri3.Serial();
		dri3.Parallel();
		
		Driver dri4 = new Driver(M, N, K, 8, A, B);   //使用8线程
		dri4.Serial();
		dri4.Parallel();
		

	}

}
