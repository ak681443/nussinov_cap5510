package com.nussinov.parallel;

import com.nussinov.NussinovSolver;
import com.nussinov.util.RNA;
import com.nussinov.util.Util;

public class NussinovOMP implements NussinovSolver {

	public int[][] solve(RNA seq) {
		char[] sequence = seq.getSequence().toCharArray();
		int seqLength = seq.getSequence().length();
		int[][] matrix = new int[seqLength][seqLength];

		for (int i = 2; i < seqLength; i++) {
			// omp parallel for
			for (int j = i; j < seqLength; j++) {
				int start = j - i;
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
	
	static String ss = "gcgaggcuagcgcuacccgugcgccugcguggaacgauucuguggcgagugccggccgaaagcuagguccggauugcacguggagggccgcccgaagggcacucucggacauuaacccgcauucuguaccauggggcgcaaguuggacccuacgaaggagaagcgggggccaggccgaaaggcccggaagcagaagggugccgagacagaacucgucagauucuugccugcaguaagugacgaaaauuccaagaggcugucuagucgugcucgaaagagggcagccaagaggagauugggcucuguugaagccccuaagacaaauaagucuccugaggccaaaccauugccuggaaagcuaccaaaaggagcuguccagacagcugguaagaagggaccccagucccuauuuaaugcuccucgaggcaagaagcgcccagcaccuggcagugaugaggaagaggaggaggaagacucugaagaagaugguauggugaaccacggggaccucuggggcuccgaggacgaugcugauacgguagaugacuauggagcugacuccaacucugaggaugaggaggaaggugaagcguugcugcccauugaaagagcugcucggaagcagaaggcccgggaagcugcugcugggauccaguggagugaagaggagaccgaggacgaggaggaagagaaagaagugaccccugagucaggccccccaaagguggaagaggcagaugggggccugcagaucaauguggaugaggaaccauuugugcugcccccugcuggggagauggagcaggaugcccaggcuccagaccugcaacgaguucacaagcggauccaggauauugugggaauucugcgugauuuuggggcucagcgggaggaagggcggucucguucugaauaccugaaccggcucaagaaggaucuggccauuuacuacuccuauggagacuuccugcuuggcaagcucauggaccucuucccucugucugagcugguggaguucuuagaagcuaaugaggugccucggcccgucacccuccggaccaauaccuugaaaacccgacgccgagaccuugcacaggcucuaaucaaucgugggguuaaccuggauccccugggcaaguggucaaagacuggacuagugguguaugauucuucugugcccauuggugcuacccccgaguaccuggcugggcacuacaugcugcagggagccuccagcauguugcccgucauggccuuggcaccccaggaacaugagcggauccuggacauguguugugccccuggaggaaagaccagcuacauggcccagcugaugaagaacacgggugugauccuugccaaugacgccaaugcugagcggcucaagaguguugugggcaacuugcaucggcugggagucaccaacaccauuaucagccacuaugaugggcgccaguuccccaaggugguggggggcuuugaccgaguacugcuggaugcucccugcaguggcacuggggucaucuccaaggauccagccgugaagacuaacaaggaugagaaggacauccugcgcugugcucaccuccagaaggaguugcuccugagugcuauugacucugucaaugcgaccuccaagacaggaggcuaccugguuuacugcaccuguucuaucacaguagaagagaaugagugggugguagacuaugcucugaaaaagaggaaugugcgacuggugcccacgggccuagacuuuggccaggaagguuuuacccgcuuucgagaaaggcgcuuccaccccagucugcguucuacccgacgcuucuacccucauacccacaauauggauggguucuucauugccaaguucaagaaauuuuccaauucuaucccucagucccagacaggaaauucugaaacagccacaccuacaaauguagacuugccucaggucauccccaagucugagaacagcagccagccagccaagaaagccaagggggcugcaaagacaaagcagcagcugcagaaacagcaacaucccaagaaggccuccuuccagaagcugaauggcaucuccaaaggggcagacucagaauuguccacuguaccuucugucacaaagacccaagcuuccuccagcuuccaggauagcagucagccagcuggaaaagccgaagggaucagggagccaaaggugacugggaagcuaaagcaacgaucaccuaaauuacaguccuccaagaaaguugcuuuccucaggcagaaugccccucccaagggcacagacacacaaacaccggcuguguuauccccauccaagacucaggccacccugaaaccuaaggaccaucaucagccccuuggaagggccaaggggguugagaagcagcaguugccagagcagccuuuugagaaagcugccuuccagaaacagaaugauacccccaaggggccucagccucccacugugucucccauccguuccagccgccccccaccagcaaagaggaagaaaucucaguccaggggcaacagccagcugcugcuaucuuagaugguugaaaacuagacggguggcucacugccauugucaccagguuggaacucuugccucugugaggaugccuucucuacugugcauacccaugaaauuuaauacacauuuuaaaaccucuggaaaaaaaaaaaaaaaaaaaaaaaa";
	
	public static void main(String[] args) {
		NussinovOMP o = new NussinovOMP();
		RNA sequence = RNA.create(ss.toUpperCase(), "");
		long start = System.currentTimeMillis();
		int [][] mat = o.solve(sequence);
		
		System.out.println(mat[0][mat.length-1]);
		System.out.println((System.currentTimeMillis()-start)+" millis");
		System.out.println(Util.doTraceback(sequence, mat));		
	}
}
