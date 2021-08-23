import java.io.*;

public class Solution{
	String inputLine;
	boolean luckyNumber;
	
	public String dToC(int count, int num) {
		String temp = "";
		for (int i = 0; i < count; i++) {
			temp = temp + num;
		}
		return temp;
	}
	
	public String getNumbers(String s) {

		int zero = 0;
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		int seven = 0;
		int eight = 0;
		int nine = 0;

		int n = s.length();

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'Z')
				zero++;
			if (s.charAt(i) == 'O')
				one++;
			if (s.charAt(i) == 'W')
				two++;
			if (s.charAt(i) == 'H')
				three++;
			if (s.charAt(i) == 'U')
				four++;
			if (s.charAt(i) == 'V')
				five++;
			if (s.charAt(i) == 'X')
				six++;
			if (s.charAt(i) == 'S')
				seven++;
			if (s.charAt(i) == 'G')
				eight++;
			if (s.charAt(i) == 'N')
				nine++;
		}

		one = one - (two + four + zero);
		three = three - eight;
		seven = seven - six;
		five = five - seven;
		nine = (nine - (one + seven)) / 2;

		String finalString = dToC(zero, 0) + dToC(one, 1) + dToC(two, 2) + dToC(three, 3) + dToC(four, 4)
				+ dToC(five, 5) + dToC(six, 6) + dToC(seven, 7) + dToC(eight, 8) + dToC(nine, 9);
		return finalString;
	}

	
	private void read() throws IOException{
		try{
			//FileReader fr = new FileReader("C:/Users/a676508/workspace/devWorks/CM4.0/src/Problem2_input.txt");
			FileReader fr = new FileReader("Problem2_input.txt");
			BufferedReader br = new BufferedReader(fr);
			//File file = new File("C:/Users/a676508/workspace/devWorks/CM4.0/src/Problem2_output.txt");
			File file = new File("Problem2_output.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			int count = 0;
			int totalRooms =0;
			int roomCounter =0;
			String strOp = "";
			
			while((inputLine = br.readLine())!=null){
				String[] dataArr = inputLine.split(" ");
				if(count==0){
					totalRooms = Integer.parseInt(dataArr[0]);
					count++;
					continue;
				}else{
					roomCounter++;
				// strOp = getNumbers(inputLine);
					bw.write("Room-:"+roomCounter+":"+getNumbers(inputLine));
					System.out.println("Room-:"+roomCounter+":"+getNumbers(inputLine));
					bw.flush();
					
				}
			
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