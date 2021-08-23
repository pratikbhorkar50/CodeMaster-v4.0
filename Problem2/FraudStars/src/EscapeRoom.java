
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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
			List<String> inputDataLine = new ArrayList<String>();		// Storage for outline Line to be written in output file

			while ((line = bufferedReader.readLine()) != null) {
				//System.out.println(line);			// Output Per Line Data

				if(i == 0){
					totalnoOfRooms = Long.valueOf(line);
				}else{
					encryptedKey = new String(line);
					currentRoomNumber++;
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



	/***return New Lucky Number***/
	
	public static String decoder(String encryptedString){
		
		
		return "0123456789";
	}

	



}