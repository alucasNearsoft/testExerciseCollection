package com.companyname.collection.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReadFileDisplayRandom {

	private String fileName;
	private int randomRows = 0;
	private int assumedDataStructureRows = 0;

	private List<String> theList;
	private long fileLength;
	private int realRows = 0;
	private final int CHARS_PER_ROW = 80;

	/*
	public static void main(String[] args) {
		if (args.length > 1) {
			ReadFileDisplayRandom theFile = new ReadFileDisplayRandom();
			theFile.fileName = args[0];
			theFile.randomRows = Integer.parseInt(args[1], 10);

			theFile.readFile();
			theFile.displayRandomRows();
		}
		else {
			System.out.println("Add arguments: <file> <number of random lines to print>");
		}
	}
	*/
	
	/*
	 * Gets the file length to calculate a data structure size, 
	 * then reads line by line the file to add them to the data structure 
	 */
	public void readFile() {
		File file = new File(fileName);
		fileLength = file.length();

		assumedDataStructureRows = (int) fileLength / CHARS_PER_ROW;

		theList = new ArrayList<>(assumedDataStructureRows);

		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(file.toPath(),
				charset)) {
			String line = null;
			realRows = 0;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				theList.add(line);
				realRows++;
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

	/*
	 * Displays random lines from the data structure 
	 */
	public void displayRandomRows() {
		Random random = new Random();
		for (int i = 0; i < randomRows; i++) {
			int row = random.nextInt(realRows);
			String theRow = theList.get(row);
			System.out.println(theRow);
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getRandomRows() {
		return randomRows;
	}

	public void setRandomRows(int randomRows) {
		this.randomRows = randomRows;
	}

	public List<String> getTheList() {
		return theList;
	}

}
