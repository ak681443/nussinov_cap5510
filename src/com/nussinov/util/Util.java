package com.nussinov.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		//TODO: implement traceback later
		return null;
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
