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
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/output_serial.txt")));
			
			NussinovSolver solver = new Nussinov(); //TODO implement this interface for both seq & parallel
			for(RNA sequence : dataset){
				int dpMatrix [][] = solver.solve(sequence);
				long start = System.currentTimeMillis();
				String traceback = Util.doTraceback(sequence, dpMatrix);
				bw.write((System.currentTimeMillis() - start)+",");
				bw.write(traceback + "\n");
			}
			bw.close();
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/output_serial_cache.txt")));
			
			solver = new NussinovCacheOptimized(); //TODO implement this interface for both seq & parallel
			for(RNA sequence : dataset){
				int dpMatrix [][] = solver.solve(sequence);
				long start = System.currentTimeMillis();
				String traceback = Util.doTraceback(sequence, dpMatrix);
				bw.write((System.currentTimeMillis() - start)+",");
				bw.write(traceback + "\n");
			}
			bw.close();
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/output_parallel.txt")));
						
			solver = new NussinovOMP(); //TODO implement this interface for both seq & parallel
			for(RNA sequence : dataset){
				int dpMatrix [][] = solver.solve(sequence);
				long start = System.currentTimeMillis();
				String traceback = Util.doTraceback(sequence, dpMatrix);
				bw.write((System.currentTimeMillis() - start)+",");
				bw.write(traceback + "\n");
			}
			bw.close();
			
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data/output_parallel_cache.txt")));

			solver = new com.nussinov.parallel.NussinovCacheOptimized(); //TODO implement this interface for both seq & parallel
			for(RNA sequence : dataset){
				int dpMatrix [][] = solver.solve(sequence);
				long start = System.currentTimeMillis();
				String traceback = Util.doTraceback(sequence, dpMatrix);
				bw.write((System.currentTimeMillis() - start)+",");
				bw.write(traceback + "\n");
			}
			bw.close();
		}
}
