package com.nussinov;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import com.nussinov.parallel.NussinovOMP;
import com.nussinov.sequential.Nussinov;
import com.nussinov.sequential.NussinovCacheOptimized;
import com.nussinov.util.RNA;
import com.nussinov.util.Util;

public class Main {

	public static void main(String[] args) throws Exception {
		List<RNA> dataset = Util.readDataset();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/output_allocation_times.txt")));
		
		//pre allocating memory to make fair measurements
		
		for(RNA sequence : dataset) {
			long start = System.currentTimeMillis();
			Util.allocateMemory(sequence.getSequence().length());
			bw.append(sequence.getSequence().length()+ ",");
			bw.append((System.currentTimeMillis() - start) + "\n");
		}
		bw.close();
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/output_serial.txt")));
		NussinovSolver solver = new Nussinov();
		for (RNA sequence : dataset) {
			long start = System.currentTimeMillis();
			int dpMatrix[][] = solver.solve(sequence);
			bw.append((System.currentTimeMillis() - start) + ",");
			String traceback = Util.doTraceback(sequence, dpMatrix);
			bw.append(traceback + "\n");
			bw.flush();
		}
		bw.close();
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/output_serial_cache.txt")));

		solver = new NussinovCacheOptimized();
		for (RNA sequence : dataset) {
			long start = System.currentTimeMillis();
			int dpMatrix[][] = solver.solve(sequence);
			bw.append((System.currentTimeMillis() - start) + ",");
			String traceback = Util.doTraceback(sequence, dpMatrix);
			bw.append(traceback + "\n");
			bw.flush();
		}
		bw.close();
		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/output_parallel.txt")));

		solver = new NussinovOMP();
		for (RNA sequence : dataset) {
			long start = System.currentTimeMillis();
			int dpMatrix[][] = solver.solve(sequence);
			bw.append((System.currentTimeMillis() - start) + ",");
			String traceback = Util.doTraceback(sequence, dpMatrix);
			bw.append(traceback + "\n");
			bw.flush();
		}
		bw.close();

		bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/output_parallel_cache.txt")));

		solver = new com.nussinov.parallel.NussinovCacheOptimized(); 
		for (RNA sequence : dataset) {
			long start = System.currentTimeMillis();
			int dpMatrix[][] = solver.solve(sequence);
			bw.append((System.currentTimeMillis() - start) + ",");
			String traceback = Util.doTraceback(sequence, dpMatrix);
			bw.append(traceback + "\n");
			bw.flush();
		}
		bw.close();
	}
}
