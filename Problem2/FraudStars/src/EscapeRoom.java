
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EscapeRoom {

	static long currentRoomNumber = 0;
	static long totalnoOfRooms = 0;
	public static void main(String[] args) {
		try {
			/**********************File Reader*************************/
			String basePath = new File("").getAbsolutePath();
			FileReader reader = new FileReader(basePath+"\\src\\Input\\Problem2_input.txt");  // Input File destination
			BufferedReader bufferedReader = new BufferedReader(reader);
			String encryptedKey = "";
			long i = 0;
			String line; // To store InputLine Data
			List<String> inputDataLine = new ArrayList<>();		// Storage for outline Line to be written in output file

			while ((line = bufferedReader.readLine()) != null) {
				//System.out.println(line);			// Output Per Line Data

				if(i == 0){
					totalnoOfRooms = Long.valueOf(line);
				}else{
					encryptedKey = line;
					currentRoomNumber++;
					System.out.println("Room no in: "+currentRoomNumber);
					inputDataLine.add("Room-"+""+currentRoomNumber+""+" : "+decoder(encryptedKey));  // write output
				}
				i++;
			}
			reader.close();
			/**************Send to Writer*******************/  
			outputWriter(inputDataLine);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Write the output to the File.
	 * 
	 */
	public static void outputWriter(Object obj) throws IOException{	
		try {

			String basePath = new File("").getAbsolutePath();
			FileOutputStream outputStream = new FileOutputStream(basePath+"\\src\\Output\\output.txt");
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

			if(obj instanceof ArrayList)
			{
				List iterate  = (ArrayList)obj;
				for (Iterator iterator = iterate.iterator(); iterator.hasNext();) {
					String strLine = (String) iterator.next();
					bufferedWriter.write(strLine);
					bufferedWriter.newLine();
				}

				bufferedWriter.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	/***return Room encrypted Key***/
	
	public static String decoder(String encryptedString){

		StringBuilder str = new StringBuilder(encryptedString);

		List<Integer> keyArray = new ArrayList<Integer>();

		while (str.length() > 0) {

			while(str.indexOf("Z") >= 0 && str.indexOf("E") >= 0 && str.indexOf("R") >= 0 && str.indexOf("O") >= 0) {

				str.deleteCharAt(str.indexOf("Z")).deleteCharAt(str.indexOf("E")).deleteCharAt(str.indexOf("R")).deleteCharAt(str.indexOf("O"));
				keyArray.add(0);
			}
			while(str.indexOf("O") >= 0 && str.indexOf("N") >= 0 && str.indexOf("E") >= 0) {
				str.deleteCharAt(str.indexOf("O")).deleteCharAt(str.indexOf("N")).deleteCharAt(str.indexOf("E"));
				keyArray.add(1);
			}
			
			while(str.indexOf("N") >= 0 && str.indexOf("I") >= 0 && str.indexOf("N", str.indexOf("N") + 1) >= 0 && str.indexOf("E") >= 0) {
				str.deleteCharAt(str.indexOf("N")).deleteCharAt(str.indexOf("I")).deleteCharAt(str.indexOf("N")).deleteCharAt(str.indexOf("E"));
				keyArray.add(9);
			}
			
			while(str.indexOf("S") >= 0 && str.indexOf("I") >= 0 && str.indexOf("X") >= 0)
			{
				str.deleteCharAt(str.indexOf("S")).deleteCharAt(str.indexOf("I")).deleteCharAt(str.indexOf("X"));
				keyArray.add(6);
			}

			while(str.indexOf("S") >= 0 && str.indexOf("E") >= 0 && str.indexOf("V") >= 0 && str.indexOf("E", str.indexOf("E") + 1) >= 0 && str.indexOf("N") >= 0 ) {
				str.deleteCharAt(str.indexOf("S")).deleteCharAt(str.indexOf("E")).deleteCharAt(str.indexOf("V")).deleteCharAt(str.indexOf("E")).deleteCharAt(str.indexOf("N"));
				keyArray.add(7);
			}
			
			while(str.indexOf("E") >= 0 && str.indexOf("I") >= 0 && str.indexOf("G") >= 0 && str.indexOf("H") >= 0 && str.indexOf("T") >= 0 ) {
				str.deleteCharAt(str.indexOf("E")).deleteCharAt(str.indexOf("I")).deleteCharAt(str.indexOf("G")).deleteCharAt(str.indexOf("H")).deleteCharAt(str.indexOf("T"));
				keyArray.add(8);
			}
			
			while(str.indexOf("F") >= 0 && str.indexOf("O") >= 0 && str.indexOf("U") >= 0 && str.indexOf("R") >= 0 ) {
				str.deleteCharAt(str.indexOf("F")).deleteCharAt(str.indexOf("O")).deleteCharAt(str.indexOf("U")).deleteCharAt(str.indexOf("R"));
				keyArray.add(4);
			}

			while(str.indexOf("F") >= 0 && str.indexOf("I") >= 0 && str.indexOf("V") >= 0 && str.indexOf("E") >= 0 ) {
				str.deleteCharAt(str.indexOf("F")).deleteCharAt(str.indexOf("I")).deleteCharAt(str.indexOf("V")).deleteCharAt(str.indexOf("E"));
				keyArray.add(5);
			}
			
			while(str.indexOf("T") >= 0 && str.indexOf("W") >= 0 && str.indexOf("O") >= 0) {
				str.deleteCharAt(str.indexOf("T")).deleteCharAt(str.indexOf("W")).deleteCharAt(str.indexOf("O"));
				keyArray.add(2);
			}

		
			while(str.indexOf("T") >= 0 && str.indexOf("H") >= 0 && str.indexOf("R") >= 0 && str.indexOf("E") >= 0 && str.indexOf("E", str.indexOf("E") + 1) >= 0 ) {  
				str.deleteCharAt(str.indexOf("T")).deleteCharAt(str.indexOf("H")).deleteCharAt(str.indexOf("R")).deleteCharAt(str.indexOf("E")).deleteCharAt(str.indexOf("E"));
				keyArray.add(3);
			}
			
		}

		Collections.sort(keyArray);
		System.out.println(keyArray.toString().replace(",", "").replace("[", "").replace("]", "").replace(" ", ""));
		return (keyArray.toString().replace(",", "").replace("[", "").replace("]", "").replace(" ", ""));

	}

	



}