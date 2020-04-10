package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	
	public static void main(String args[]) throws Exception {
		ISymptomReader reader = new ReadSymptomDataFromFile("D:\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt");
		List<String> symptomList = reader.getSymptoms();
		
		 Map<String,Integer> symptomMap = new TreeMap<>();
			
			for (String s : symptomList) {
				if (symptomMap.get(s) == null) {
					symptomMap.put(s,0);
				}
				int currentValue = symptomMap.get(s);
				symptomMap.put(s, currentValue +1);
			}
		
		
		
	        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter ("result.out")));
			
			for (Map.Entry<String, Integer> entry : symptomMap.entrySet()) {
				writer.print(entry.getKey() + " = " + entry.getValue() + System.getProperty("line.separator"));
				
			}		
		writer.close();
}
