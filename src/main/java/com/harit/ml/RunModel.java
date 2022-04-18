package com.harit.ml;

import java.util.List;

import org.openjdk.jol.info.GraphLayout;

import com.harit.ml.service.helpers.ReadCSV;

public class RunModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadCSV csvReader = new ReadCSV();
		List<String[]> data = csvReader.readCSV("D:\\Downloads\\datasets\\jobs.csv", ",");
//		System.out.println(VM.current().details());
		System.out.println(GraphLayout.parseInstance(data).totalSize()/1024 + " KB");

	}

}
