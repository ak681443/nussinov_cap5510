package com.nussinov.util;

public class RNA {
	
	private String structure;
	private String sequence;

	private RNA(){
		
	}
	
	public static RNA create(String sequence, String structure){
		RNA rna = new RNA();
		rna.setSequence(sequence);
		rna.setStructure(structure);
		return rna;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
}
