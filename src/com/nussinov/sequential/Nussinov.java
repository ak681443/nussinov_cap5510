import java.util.*;

public class Nussinov implements NussinovSolver {

    private int[][] solve(String inpSequence) {
    	int seqLength = inpSequence.length();
        int[][] dpMatrix = new int[seqLength][seqLength];
        char sequence[] = inpSequence.toCharArray();

        for (int i = 1; i < seqLength; i++) {
            for (int j = i; j < seqLength; j++) {
            	int n = j-i;

            	int case1 = dpMatrix[n+1][j];
                int case2 = dpMatrix[n][j-1];
                int case3 = score(sequence[n], sequence[j]) + dpMatrix[n+1][j -1];
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

    private int score(Character base1, Character base2) {
        int score = 0;
        if (base1.equals('U') && base2.equals('A') || base1.equals('A') && base2.equals('U')) {
            score = 1;
        } else if (base1.equals('G') && base2.equals('C') || base1.equals('C') && base2.equals('G')) {
            score = 1;
        } else {
            score = 0;
        }
        return score;

    }

    public static void main(String args[]) {
    	Nussinov ob = new Nussinov();
        String seq = "GGGAAAUCC";


        int matrix[][] = ob.solve(seq);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}