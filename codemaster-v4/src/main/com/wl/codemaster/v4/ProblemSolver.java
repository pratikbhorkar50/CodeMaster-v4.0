package com.wl.codemaster.v4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProblemSolver {
	private static final String inputFileName = "src/resources/Problem2_input.txt";
	private static final String outputFileName = "src/resources/Problem2_output.txt";

//	private static final String inputFileName = "src/resources/Input.txt";
//	private static final String outputFileName = "src/resources/Output.txt";

	private static final List<String> allowedStringsLst = Arrays.asList("ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE",
			"SIX", "SEVEN", "EIGHT", "NINE");
	private static final String[] allowedStringsArr = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN",
			"EIGHT", "NINE" };

//	private static final Map<String, Integer> standardNumString = new HashMap<>();
//
//	static {
//		standardNumString.put("ZERO", 4);
//		standardNumString.put("ONE", 3);
//		standardNumString.put("TWO", 3);
//		standardNumString.put("THREE", 5);
//		standardNumString.put("FOUR", 4);
//		standardNumString.put("FIVE", 4);
//		standardNumString.put("SIX", 3);
//		standardNumString.put("SEVEN", 5);
//		standardNumString.put("EIGHT", 5);
//		standardNumString.put("NINE", 4);
//	}

	public static void main(String[] args) {
		List<String> inputList = readFileInList(inputFileName);
		List<String> outputList = new ArrayList<>();
		Iterator<String> itr = inputList.iterator();

		int i = -1;
		while (itr.hasNext()) {
			i += 1;
			if (i == 0) { // ignore first line
				itr.next();
				continue;
			}
			String inpStr = itr.next();
			String outputStr = "Room-" + i + ": " + processInputString(inpStr);
			System.out.println(outputStr);
			outputList.add(outputStr);
		}

		deleteFileIfExists();
		writeFileFromList(outputList);
	}

	private static String processInputString(String str) {
		List<String> obtainedValidNumStrings = new ArrayList<>();
		Map<String, String> processNumString = new HashMap<>();
		processNumString.put("ZERO", "");
		processNumString.put("ONE", "");
		processNumString.put("TWO", "");
		processNumString.put("THREE", "");
		processNumString.put("FOUR", "");
		processNumString.put("FIVE", "");
		processNumString.put("SIX", "");
		processNumString.put("SEVEN", "");
		processNumString.put("EIGHT", "");
		processNumString.put("NINE", "");

		String[] ch = str.split("");
		for (String c : ch) {
			for (String entry : allowedStringsLst) {
				int count = countMatches(entry, c);
				if (count > 0) {
					String value = processNumString.get(entry);
					int countInValue = countMatches(value, c);

					if (countInValue < count) {
						processNumString.put(entry, processNumString.get(entry) + c);
					}
				}
			}
		}

		for (Map.Entry<String, String> entry : processNumString.entrySet()) {
			String standardKey = entry.getKey();
			String standardValue = entry.getValue();
			if (standardKey.length() == standardValue.length() && equivalent(standardKey, standardValue)) {
				obtainedValidNumStrings.add(standardKey);
			}
		}

//		obtainedValidNumStrings.add("ONE");
//		obtainedValidNumStrings.add("NINE");
//		obtainedValidNumStrings.add("EIGHT");

		// convert the words to number
		List<Integer> convertedValidNumbers = new ArrayList<>();
		for (String validStr : obtainedValidNumStrings) {
			convertedValidNumbers.add(Arrays.asList(allowedStringsArr).indexOf(validStr));
		}

		// sort and convert into string
		Collections.sort(convertedValidNumbers);
		String output = convertedValidNumbers.stream().map(Object::toString).collect(Collectors.joining(""));
		return output;
	}

	private static boolean equivalent(String s1, String s2) {
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();

		Arrays.sort(chars1);
		Arrays.sort(chars2);

		return Arrays.equals(chars1, chars2);
	}

	private static int countMatches(String text, String str) {
		int index = 0, count = 0;
		while (true) {
			index = text.indexOf(str, index);
			if (index != -1) {
				count++;
				index += str.length();
			} else {
				break;
			}
		}
		return count;
	}

	private static List<String> readFileInList(String fileName) {
		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	private static void deleteFileIfExists() {
		File file = new File(outputFileName);
		if (file != null) {
			if (file.exists()) {
				file.delete();
			}
		}
	}

	private static void writeFileFromList(List<String> list) {
		if (list == null || list.isEmpty())
			return;

		try {
			FileWriter writer = new FileWriter(outputFileName, true);
			Iterator<String> itr = list.iterator();
			while (itr.hasNext()) {
				writer.write(itr.next());
				writer.write("\r\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
