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
		String path = "symptoms.txt";
		AnalyticsCounter ac = new AnalyticsCounter();
		List<String> symptomList = ac.read(path);
		Map<String, Integer> symptomMap = ac.sort(symptomList);
		ac.write(symptomMap);	
	}
	
	private List<String> read(String path) {
		
		ISymptomReader reader = new ReadSymptomDataFromFile(path);
		List<String> symptomList = reader.getSymptoms();
		return symptomList;
		
	}
	
	private Map<String, Integer> sort(List<String> symptomList) {
		
        Map<String,Integer> symptomMap = new TreeMap<>();
		
		for (String s : symptomList) {
			if (symptomMap.get(s) == null) {
				symptomMap.put(s,0);
			}
			int currentValue = symptomMap.get(s);
			symptomMap.put(s, currentValue +1);
		}
		return symptomMap;
		
	}
	
	private void write(Map<String, Integer> symptomMap) throws IOException {
		
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter ("result.out")));
		
		for (Map.Entry<String, Integer> entry : symptomMap.entrySet()) {
			writer.print(entry.getKey() + " = " + entry.getValue() + System.getProperty("line.separator"));
			
		}
		
		
		writer.close();
	}
}
