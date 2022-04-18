package com.harit.ml.service.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

// https://www.edureka.co/blog/read-write-excel-file-in-java/#HowtoreadCSVfileinJava?
public class ReadCSV {
	
	public List<String[]> readCSV(String filepath, String seperator) {
		try {
			List<String[]> data = new ArrayList<String[]>();
			
			BufferedReader inFile = new BufferedReader(new FileReader(filepath));
			
			String line = inFile.readLine();
			String[] header = line.split(seperator);
			while((line  = inFile.readLine()) != null) {
				String[] cells = line.split(seperator);
				if (cells.length != header.length) {
					inFile.close();
					throw new DataIntegrityViolationException("Data Mismatch in CSV file at line " + data.size()+1);
				}
				data.add(cells);
			}
			
			inFile.close();
			System.out.println(data.size() + " lines of data read.");
			return data;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
			
	}

}
