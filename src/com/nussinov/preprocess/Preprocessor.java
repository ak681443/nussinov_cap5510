package com.nussinov.preprocess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Preprocessor {
	
	static String directoryList[] = new String [] { "data/pdb", "data/rnastrand"};  
	
	public static void main(String[] args) throws Exception {
		File inputFile = new File("data/input.txt"), outputFile = new File("data/output.txt");
		
		inputFile.delete();
		outputFile.delete();
		
		BufferedWriter inputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(inputFile)));
		BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
				
		for(String path : directoryList){
			File dir = new File(path);
			if(dir.isDirectory()){
				char secondaryStructure [] = new char[5000];
				for(File file : dir.listFiles()){
					if(file.getPath().endsWith("ct")) {
						continue;						
					}
					BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					StringBuilder originalSequence = new StringBuilder();
					Arrays.fill(secondaryStructure, '.');
					
					String line = br.readLine();
					while(line!=null){
						line = line.trim();
						if(line.startsWith("#")) continue;
						// ID , Nucleotide, Match ID
						String components[] = line.split(" ");
						originalSequence.append(components[1]);
						int start = Integer.valueOf(components[0]), end = Integer.valueOf(components[2]);
						if(start < end && end > 0){
							secondaryStructure[start - 1] = '(';
							secondaryStructure[end - 1] = ')';
						}
						line = br.readLine();
					}
					br.close();
					String sequence = originalSequence.append('\n').toString();
					String secondary = new String(secondaryStructure).substring(0, originalSequence.length()-1) + "\n";
					
					inputWriter.write(sequence);
					outputWriter.write(secondary);
					
					
					//sanity checks
					if(sequence.length() != secondary.length()){
						inputWriter.close();
						throw new Exception("length mismatch @ " + file.getName());
					}
				}
			}
		}
		
		inputWriter.close();
		outputWriter.close();
	}
}
