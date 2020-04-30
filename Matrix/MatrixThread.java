package Matrix;

public class MatrixThread implements Runnable{
	private int start;
	private double[][] A;
	private double[][] B;
	private double[][] C;
	
	public MatrixThread(int start,double[][] A,double[][] B,double[][] C){
		this.start=start;
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	@Override
	public void run() {
		int i,j,k;
		for(i=start; i<Driver.M; i += Driver.NUM_THREADS){      
			for(j=0;j<Driver.N;j++){           
				for( k=0; k< Driver.K;k++) {         
					C[i][j]+=A[i][k]*B[k][j];
				}
			}
		}
	}

}
