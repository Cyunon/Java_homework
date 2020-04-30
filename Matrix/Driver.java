package Matrix;

public class Driver {
	public static int M;
	public static int K;
	public static int N;
	public static int NUM_THREADS;
	private static double[][] A;
	private static double[][] B;
	private static double[][] C1;
	private static double[][] C2;

	public Driver(int M, int K, int N, int NUM_THREADS, double[][] A, double[][] B){
		this.M = M;
		this.K = K;
		this.N = N;
		this.NUM_THREADS = NUM_THREADS;
		this.A = A;
		this.B = B;	
		C1 = new double [M][N];
		C2 = new double [M][N];
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				C1[i][j]=0;
				C2[i][j]=0;
			}
		}
	}
	
	public static void singleThread(){
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				for(int k=0;k<K;k++) {
					C1[i][j] += A[i][k] * B[k][j];
				}
			}
		}
	}
	
	public void Serial() {
		long time1 = System.currentTimeMillis();
		singleThread();
		long time2 = System.currentTimeMillis();
		System.out.println("计算 [" + M + ", " + N + "] 和 [" + N + ", " + K + "] 相乘，使用串行，用时: " + (time2 - time1) + " 毫秒");
	}
	
	public void Parallel() {
		Thread[] workers=new Thread[NUM_THREADS];
		for(int i=0;i<NUM_THREADS;i++) {
			workers[i]=new Thread(new MatrixThread(i,A,B,C2));
		}
		
		long time1= System.currentTimeMillis();
		
		for(int i=0; i<NUM_THREADS; i++){
			workers[i].start();
		}
		
		for(int i=0;i<NUM_THREADS;i++){
			try{
				workers[i].join();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		long time2 = System.currentTimeMillis();
		System.out.print("计算 [" + M + ", " + N + "] 和 [" + N + ", " + K + "] 相乘，使用并行(" + NUM_THREADS + " 线程)，用时: " + (time2 - time1) + " 毫秒  ");
		judge();
		System.out.print("\r\n");
	}
	
	public void judge() {
		boolean isRight = true;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(Math.abs(C1[i][j] - C2[i][j]) > 0.5) {
					isRight = false;
					break;
				}
			}
		}
		try {
			assert isRight : "计算错误";
			System.out.print("计算正确");
		}catch (AssertionError err) {
            System.out.println(err.getMessage());
        }	
	}

}
