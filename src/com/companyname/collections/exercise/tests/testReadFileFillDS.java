package com.companyname.collections.exercise.tests;

import static org.junit.Assert.fail;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.companyname.collection.exercise.ReadFileDisplayRandom;

public class testReadFileFillDS extends TestCase{

	private ReadFileDisplayRandom theFile;
	private String fileName;
	private int randomRows;

	@Before
	public void setUp() throws Exception {
		fileName = "Exercise.txt";
		randomRows = 2;
		theFile = new ReadFileDisplayRandom();
		theFile.setFileName(fileName);
		theFile.setRandomRows(randomRows);
	}

	@Test
	public void testReadFile() {
		List<String> testList = null;
		theFile.readFile();
		testList = theFile.getTheList();

		if (testList.isEmpty()) {
			fail("The list is empty!");
		}
	}
	
	@Test
	public void testDisplayRandomRows() {
		theFile.readFile();
		theFile.displayRandomRows();
	}

}
