package com.papercut.operations;



public enum PaperType {
	A4 (25,20,15,10);
	
	public final double colorSingleSide;
	public final double colorDoubleSide;
	public final double bwSingleSide;
	public final double bwDoubleSide;
	
	PaperType(double colorSingleSide, double colorDoubleSide, double bwSingleSide, double bwDoubleSide){
		this.colorSingleSide = colorSingleSide;
	    this.colorDoubleSide = colorDoubleSide;
	    this.bwSingleSide = bwSingleSide;
	    this.bwDoubleSide = bwDoubleSide;
	}
	
	private double getcolorSingleSide() { return colorSingleSide; }
	private double getcolorDoubleSide() { return colorDoubleSide; }
	private double getbwSingleSide() { return bwSingleSide; }
	private double getbwDoubleSide() { return bwDoubleSide; }

}

