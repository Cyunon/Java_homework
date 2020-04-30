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
		Driver dri = new Driver(M, N, K, 2, A, B);   //ʹ��2�߳�
		dri.Serial();
		dri.Parallel();
		
		Driver dri2 = new Driver(M, N, K, 4, A, B);   //ʹ��4�߳�
		dri2.Serial();
		dri2.Parallel();
		
		Driver dri3 = new Driver(M, N, K, 6, A, B);   //ʹ��6�߳�
		dri3.Serial();
		dri3.Parallel();
		
		Driver dri4 = new Driver(M, N, K, 8, A, B);   //ʹ��8�߳�
		dri4.Serial();
		dri4.Parallel();
		

	}

}
