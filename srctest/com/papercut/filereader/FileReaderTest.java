package com.papercut.filereader;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Test;
import com.papercut.operations.CostCalculator;
import com.papercut.operations.PaperType;


public class FileReaderTest {

	private FileReader fileReader;
	public final double colorSingleSide = 25;
	public final double colorDoubleSide = 20;
	public final double bwSingleSide = 15;
	public final double bwDoubleSide = 10;
	CostCalculator costCalculator = new CostCalculator();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFileExists() throws FileNotFoundException {
		Boolean copyOffile = Files.exists(Paths.get("C:\\Users\\d349406\\Downloads\\printjobs.csv"));
		if (!copyOffile) {
		   throw new FileNotFoundException("file not found");
		}
	}
	
	@Test
	public void testreadFileAndCalculate() throws FileNotFoundException {
		assertEquals(fileReader.readFromFile(),64.1,0);
	}
	
	@Test
	public void testEnum() {
		double colorSingle = 25;
		double colorDouble = 20;
		double bwSingle = 15;
		double bwDouble = 10;
		assertEquals(colorSingle,PaperType.A4.colorSingleSide,0);
		assertEquals(colorDouble,PaperType.A4.colorDoubleSide,0);
		assertEquals(bwSingle,PaperType.A4.bwSingleSide,0);
		assertEquals(bwDouble,PaperType.A4.bwDoubleSide,0);
	}

}
