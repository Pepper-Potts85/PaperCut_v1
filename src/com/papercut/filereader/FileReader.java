package com.papercut.filereader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.papercut.operations.CostCalculator;

/*
 * Reads the file of any format -.csv, .xls, .txt
 * return type : double
 */

public class FileReader implements ReadFile {

	public double readFromFile() {
		
		CostCalculator costCalculator = new CostCalculator();
		double totalCost = 0;
		
		try {
			
			List<String> fileStringArray = Files.readAllLines(Paths.get("C:\\Users\\d349406\\Downloads\\printjobs.csv"), StandardCharsets.UTF_8);
			totalCost = costCalculator.readStringArray(fileStringArray);
								
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return totalCost;
		
	}
	
	
	
	
}

