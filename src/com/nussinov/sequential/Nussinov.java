package com.nussinov.sequential;

import com.nussinov.NussinovSolver;
import com.nussinov.util.RNA;
import com.nussinov.util.Util;

public class Nussinov implements NussinovSolver {

	@Override
    public int[][] solve(RNA rnaSequence) {
		String inpSequence = rnaSequence.getSequence();
    	int seqLength = inpSequence.length();
        int[][] dpMatrix = new int[seqLength][seqLength];
        char sequence[] = inpSequence.toCharArray();

        for (int i = 1; i < seqLength; i++) {
            for (int j = i; j < seqLength; j++) {
            	int n = j-i;

            	int case1 = dpMatrix[n+1][j];
                int case2 = dpMatrix[n][j-1];
                int case3 = Util.score(sequence[n], sequence[j]) + dpMatrix[n+1][j -1];
                if(n+3 <= j) {
                	int temp = 0;

                	for(int k=n+1; k<j; k++) {
                		if(dpMatrix[n][k] + dpMatrix[k+1][j] > temp) {
                			temp = dpMatrix[n][k] + dpMatrix[k+1][j];
                		}
                	}
                	int tempMax1 = Math.max(case1, case2);
        			int tempMax2 = Math.max(case3, temp);
        			dpMatrix[n][j] = Math.max(tempMax1, tempMax2);
                } else {

                	int tempMax = Math.max(case1, case2);
                	dpMatrix[n][j] = Math.max(tempMax, case3);
                }
            }
        }
        return dpMatrix;
    }
}