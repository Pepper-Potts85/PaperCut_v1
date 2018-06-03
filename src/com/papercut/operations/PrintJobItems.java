package com.papercut.operations;

import java.math.BigDecimal;

public class PrintJobItems {
	
	private Boolean doubleSided;
	private BigDecimal price;
	private double colourPages;
	private double blackWhitePages;
	private double totalPages;
	
	public double getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(double totalPages) {
		this.totalPages = totalPages;
	}
	public Boolean getDoubleSided() {
		return doubleSided;
	}
	public void setDoubleSided(Boolean doubleSided) {
		this.doubleSided = doubleSided;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public double getColourPages() {
		return colourPages;
	}
	public void setColourPages(double colourPages) {
		this.colourPages = colourPages;
	}
	public double getBlackWhitePages() {
		return blackWhitePages;
	}
	public void setBlackWhitePages(double blackWhitePages) {
		this.blackWhitePages = blackWhitePages;
	}
	
	
	
}
