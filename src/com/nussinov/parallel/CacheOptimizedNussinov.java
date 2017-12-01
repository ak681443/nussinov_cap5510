package com.nussinov.parallel;

import com.nussinov.NussinovSolver;
import com.nussinov.util.RNA;
import com.nussinov.util.Util;

public class CacheOptimizedNussinov implements NussinovSolver {
	
	public int[][] solve(RNA seq) {
		char[] sequence = seq.getSequence().toCharArray();
		int seqLength = seq.getSequence().length();
		int[][] matrix = new int[seqLength][seqLength];
		int padding = 1;
		// omp parallel for
		for (int i = 1; i < seqLength; i++) {
			// omp parallel for
			for (int j = i; j < seqLength - i; j++) {
				int down = matrix[i + 1][j];
				int left = matrix[i][j - 1];
				int diagonal = Util.score(sequence[i], sequence[j]) + matrix[i + 1][j - 1];
				if (i + 3 <= j) { // Minimum gap
					int maxValue = 0;
					for (int k = i + 1; k < j; k++) {
						int tmp = matrix[i][k] + matrix[k + 1][j];
						if (tmp > maxValue) {
							maxValue = tmp;
						}
					}
					matrix[i][j] = Math.max(Math.max(down, left), Math.max(diagonal, maxValue));
				} else {
					matrix[i][j] = Math.max(Math.max(down, left), diagonal);
				}
			}
		}
		return matrix;
	}
	
	public static void main(String[] args) {
		CacheOptimizedNussinov o = new CacheOptimizedNussinov();
		int [][] mat = o.solve(RNA.create("AAAGCUUU", ""));
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
}
