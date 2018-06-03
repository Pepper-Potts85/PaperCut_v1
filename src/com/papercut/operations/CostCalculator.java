package com.papercut.operations;

import java.util.List;

public class CostCalculator implements CostCalculatorInterface {
	
	PrintJobItems printJobItems = new PrintJobItems();
	
	public double totalCostOfJobs= 0;
	
	@Override
	public double readStringArray(List<String> fileStringArray) {
		
		fileStringArray.remove(0);
		
		for (String fileString : fileStringArray){
			String fileValuesStringArray[] = fileString.split(",");
			totalCostOfJobs = calculateTotalCostOfAllJobs(calculateSingleJobCost(fileValuesStringArray));	
		}
		System.out.println("Total Cost of all jobs : $" + convertCentsToDollars(totalCostOfJobs));
		return convertCentsToDollars(totalCostOfJobs);
	}
	

	/*
	 * Set the values for the PrintJobItem bean
	 * return type : double
	 */
	private double calculateSingleJobCost(String [] fileValuesStringArray) {
		printJobItems.setTotalPages(Double.parseDouble(fileValuesStringArray[0]));
		printJobItems.setColourPages(Double.parseDouble(fileValuesStringArray[1]));
		printJobItems.setDoubleSided(convertStringToBoolean((fileValuesStringArray[2]).toString()));
		printJobItems.setBlackWhitePages(calculateBlackWhitePages(fileValuesStringArray[0],(fileValuesStringArray[1])));
		return calculateTotalJobCost(printJobItems);
	}
	
	/*
	 * Calculates the number of Black & White pages per job
	 * return type : double
	 */
	
	private double calculateBlackWhitePages(String totalPages,String colorPages) {
		double blackWhitePages = 0;
		if((totalPages != null && !totalPages.isEmpty()) && (colorPages!= null && !colorPages.isEmpty())) {
			blackWhitePages = Double.parseDouble(totalPages) - Double.parseDouble(colorPages);
		}
		return blackWhitePages;
	}
	
	/*
	 * Calculates the total cost of all jobs
	 * return type : double
	 */
	
	private double calculateTotalCostOfAllJobs(double singleJobCost) {
		return totalCostOfJobs = totalCostOfJobs+singleJobCost;
	}
	
	/*
	 * Calculates the total cost of a single job
	 * return type : double
	 */
	
	private double calculateTotalJobCost(PrintJobItems printJobItem) {
		double totalCostofJob = 0;
		
		System.out.println("Total pages : " +printJobItem.getTotalPages());
		System.out.println("Total Colour pages : " +printJobItem.getColourPages());
		System.out.println("Total Black and White pages : " +printJobItem.getBlackWhitePages());
		
		if (!printJobItem.getDoubleSided()) {
			System.out.println("Printed on Single Side Only");
			if(!(printJobItem.getColourPages() == 0 )) {
				totalCostofJob = printJobItem.getColourPages() * PaperType.A4.colorSingleSide;
			}
			
			if(!(printJobItem.getBlackWhitePages() == 0 )) {
				totalCostofJob = totalCostofJob + (printJobItem.getBlackWhitePages() * PaperType.A4.bwSingleSide);
			}
			
		}else {
			System.out.println("Printed on both sides");
			if(!(printJobItem.getColourPages() == 0 )) {
				totalCostofJob = printJobItem.getColourPages() * PaperType.A4.colorDoubleSide;
			}
			
			if(!(printJobItem.getBlackWhitePages() == 0 )) {
				totalCostofJob = totalCostofJob + (printJobItem.getBlackWhitePages() * PaperType.A4.bwDoubleSide);
			}
			
		}
		
		System.out.println("Total cost of this job : $" +convertCentsToDollars(totalCostofJob));
		System.out.println("##########################################");
		
		return totalCostofJob;
	}
	
	/*
	 * Converts cents to dollar amount
	 * return type : double
	 */
	private double convertCentsToDollars(double cents) {
		double dollars = cents/100;
        return dollars;
    }
	
	/*
	 * Converts string to Boolean object
	 * return type : Boolean
	 */
	private Boolean convertStringToBoolean(String booleanValue) {
		if(booleanValue!= null) {
			booleanValue.trim();
			if (booleanValue.contains("true")){
				return true;
			}
			else if (booleanValue.contains("false")) {
			    return false;
			    
			} else {
				//thrown exception
				return false;
			}
		}
		return false;
		
	}
}
