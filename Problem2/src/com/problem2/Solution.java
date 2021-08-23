package com.problem2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {


	public static List<String> readFileInList(String fileName){


		List<String> lines = Collections.emptyList();
		try
		{
			lines =
					Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		}

		catch (IOException e) {

			e.printStackTrace();
		}
		return lines;
	}

	public static String findDigits(String s) {

		String[] num
		= { "ZERO", "ONE", "TWO",   "THREE", "FOUR",
				"FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };

		int[] arr = new int[10];

		String ans = "";

		int n = s.length();

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'Z')
				arr[0]++;
			if (s.charAt(i) == 'W')
				arr[2]++;
			if (s.charAt(i) == 'G')
				arr[8]++;
			if (s.charAt(i) == 'X')
				arr[6]++;
			if (s.charAt(i) == 'V')
				arr[5]++;
			if (s.charAt(i) == 'O')
				arr[1]++;
			if (s.charAt(i) == 'S')
				arr[7]++;
			if (s.charAt(i) == 'F')
				arr[4]++;
			if (s.charAt(i) == 'H')
				arr[3]++;
			if (s.charAt(i) == 'I')
				arr[9]++;
		}

		arr[7] -= arr[6];
		arr[5] -= arr[7];
		arr[4] -= arr[5];
		arr[1] -= (arr[2] + arr[4] + arr[0]);
		arr[3] -= arr[8];
		arr[9] -= (arr[5] + arr[6] + arr[8]);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < arr[i]; j++) {
				ans += (char)(i + '0');
			}
		}


		return ans;
	}

	public static void main(String args[]) throws Exception{

		List<String> l = readFileInList("resources\\Problem2_input.txt");

		int numberOfRooms;

		Iterator<String> itr = l.iterator();
		numberOfRooms = Integer.parseInt(itr.next());		

		Map<Integer, String> roomKeyMap = new HashMap<Integer, String>();
		int i = 1;


		while(itr.hasNext()) {
			roomKeyMap.put(i, itr.next());
			i++;
		}
		
		BufferedWriter writer = new BufferedWriter (new FileWriter("resources\\Problem2_output.txt"));
		
		
		
		for (Map.Entry<Integer, String> entry: roomKeyMap.entrySet()) {

			writer.write("ROOM- "+ entry.getKey() + ": " + findDigits(entry.getValue()));	
			writer.write("\n");

		}
		
		writer.close();

	}


}
