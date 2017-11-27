package com.nussinov;

import java.util.List;

import com.nussinov.util.RNA;
import com.nussinov.util.Util;

public class Main {

		public static void main(String[] args) {
			List<RNA> dataset = Util.readDataset();
			NussinovSolver solver = null; //TODO implement this interface for both seq & parallel
			for(RNA sequence : dataset){
				int dpMatrix [][] = solver.solve(sequence);
				String traceback = Util.doTraceback(sequence, dpMatrix);
				System.out.println(traceback);
			}
		}
}
