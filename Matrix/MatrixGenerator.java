package Matrix;

import java.util.Random;

public class MatrixGenerator {
	private double [][]matrix;
	private int num1;
	private int num2;

	public MatrixGenerator(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		matrix = new double [num1][num2];
		matrix = setMatrix(matrix, num1, num2);
	}
	
	public MatrixGenerator() {
		this.num1 = 1;
		this.num2 = 1;
		matrix = new double [1][1];
		matrix = setMatrix(matrix, num1, num2);
	}
	
	private static double[][] setMatrix(double[][] matrix, int num1, int num2) {
		Random r = new Random(1);
		for(int i=0; i<num1; i++) {
			for(int j=0; j<num2; j++) {
				matrix[i][j] = r.nextDouble() * 1000;
			}
		}
		return matrix;
	}
	
	public double[][] getMatrix(){
		return this.matrix;
	}

}
