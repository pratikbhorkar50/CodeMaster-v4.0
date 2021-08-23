import java.io.*;

public class Solution{
	String inputLine;
	boolean luckyNumber;
	
	private void read() throws IOException{
		try{
			//FileReader fr = new FileReader("C:/Users/a676508/workspace/devWorks/CM4.0/src/Problem2_input2.txt");
			FileReader fr = new FileReader("Problem2_input.txt");
			BufferedReader br = new BufferedReader(fr);
			//File file = new File("C:/Users/a676508/workspace/devWorks/CM4.0/src/output.txt");
			File file = new File("Problem2_output.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			int count = 0;
			int totalRooms =0;
			int roomCounter =0;
			
			
			while((inputLine = br.readLine())!=null){
				String[] dataArr = inputLine.split(" ");
				System.out.println(inputLine+":"+dataArr[0]);
				
				if(count==0){
					totalRooms = Integer.parseInt(dataArr[0]);
					count++;
					continue;
				}else{
					roomCounter++;
				}
			
				bw.write("Room-:"+roomCounter+":"+inputLine);
				bw.newLine();
			}
			bw.close();

		}
		catch(IOException ioexp){
			System.out.println("io exception while reading the file"+ioexp);
		}
		catch(Exception exp){
			System.out.println("generic exception while reading file"+exp);
		}
		finally{
			System.out.println("Safe Executions.");
		}
		

	}

	public static void main(String[] args){
		System.out.println("Code Master Start");
		Solution fp = new Solution();
		System.out.println("Reading Input Data");
		try{
		fp.read();
		}
		catch(Exception exp){
			System.out.println("Exception in Main Occurred."+exp);
		}

	}
}