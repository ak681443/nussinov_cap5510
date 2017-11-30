package com.nussinov.parallel;

import com.nussinov.NussinovSolver;
import com.nussinov.util.RNA;
import com.nussinov.util.Util;

public class NussinovOMP1 implements NussinovSolver {

	public int[][] solve(RNA seq) {
		char[] sequence = seq.getSequence().toCharArray();
		int seqLength = seq.getSequence().length();
		int[][] matrix = new int[seqLength][seqLength];

		for (int i = 1; i < seqLength; i++) {
			// omp parallel for
			for (int j = i; j < seqLength; j++) {
				int start = j - i;
				System.out.println(start + ", " + j);
				int down = matrix[start + 1][j];
				int left = matrix[start][j - 1];
				int diagonal = Util.score(sequence[start], sequence[j]) + matrix[start + 1][j - 1];
				if (start + 3 <= j) { // Minimum gap
					int maxValue = 0;
					for (int k = start + 1; k < j; k++) {
						int tmp = matrix[start][k] + matrix[k + 1][j];
						if (tmp > maxValue) {
							maxValue = tmp;
						}
					}
					matrix[start][j] = Math.max(Math.max(down, left), Math.max(diagonal, maxValue));
				} else {
					matrix[start][j] = Math.max(Math.max(down, left), diagonal);
				}
			}
		}
		return matrix;
	}
	
	public static void main(String[] args) {
		NussinovOMP1 o = new NussinovOMP1();
		o.solve(RNA.create("AAAGCUUU", ""));
	}
}
