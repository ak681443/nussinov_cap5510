package com.nussinov.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
	private static boolean isDebug = false;
	
	public static List<RNA> readDataset(){
		ArrayList<RNA> dataset = new ArrayList<>();
		BufferedReader input = null, output = null;
		try{
			input = new BufferedReader(new InputStreamReader(new FileInputStream("data/input.txt")));
			output = new BufferedReader(new InputStreamReader(new FileInputStream("data/output.txt")));
			String ip = input.readLine(), op = output.readLine();
			while(ip!=null){
				dataset.add(RNA.create(ip, op));
				op = output.readLine();
				ip = input.readLine();
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			safeClose(input);
			safeClose(output);
		}
		return dataset;
	}
	
	public static String doTraceback(RNA sequence, int dpMatrix[][]){
		ArrayList<String> list = new ArrayList<>();
		traceback(0, sequence.getSequence().length()-1, dpMatrix, sequence.getSequence().toCharArray(), list);
		char result[] = new char[sequence.getSequence().length()];
		Arrays.fill(result, '.');
		for(String pair: list){
			String components[] = pair.split(",");
			result[Integer.valueOf(components[0])] = '(';
			result[Integer.valueOf(components[1])] = ')';
		}
		return new String(result);
	}
	
	private static void traceback(int i, int j, int N[][],char sequence[], ArrayList<String> result){
//		if(j <= i)return;
//		else if(N[i][j] == N[i][j-1]) {
//			traceback(i, j-1, N,sequence, result);
//		} else {
//			for(int k= i; k < j; k++){
//				if (score(sequence[k], sequence[j])==0) continue;
//				
//				if(N[i][j] == N[i][k-1] + N[k+1][j-1] + 1) {
//					result.add(k+","+j);
//					traceback(i, k-1, N,sequence, result); 
//					traceback(k + 1, j-1, N,sequence, result);
//					return;
//				}
//			}
//		}
		
		if(j <= i)return;
		else if(N[i][j] == N[i+1][j]) {
			traceback(i+1, j, N,sequence, result);
		}else if(N[i][j] == N[i][j-1]) {
			traceback(i, j-1, N,sequence, result);
		}
		else if(N[i+1][j-1] + score(sequence[i], sequence[j]) == N[i][j]) {
			result.add(i+","+j);
			traceback(i+1, j-1, N,sequence, result);
		}
		else {
			for(int k= i+1; k < j-1; k++){
				if(N[i][j] == N[i][k] + N[k+1][j]) {
//					result.add(k+","+j);
					traceback(i, k, N,sequence, result); 
					traceback(k + 1, j, N,sequence, result);
					return;
				}
			}
		}
	}
	
	public static int score(Character base1, Character base2) {
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
	
	public static void safeClose(Closeable c){
		try{
			c.close();
		}catch(Exception e){
			if(isDebug) e.printStackTrace();
		}
	}
}
