import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        try {
            File file = new File("C:\\Users\\user\\Desktop\\CodeMaster-v4.0\\Problem2\\Problem2_input.txt");

            String outputFile= "C:\\Users\\user\\Desktop\\CodeMaster-v4.0\\Problem2\\Problem2_output.txt";

            FileWriter writer = new FileWriter(outputFile, true);
            
            Scanner sc = new Scanner(file);
 
            int count= Integer.parseInt(sc.nextLine());

            for(int i=1;i<=count;i++)
            {
                String eKey= sc.nextLine();

                String dKey= DecreyptEKey(eKey.toLowerCase());

                writer.write("Room-"+ i +": " + dKey);
                writer.write("\n");

            }
            sc.close();
            writer.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static String DecreyptEKey(String eKey) {

	int[] arr = new int[10];

	String dKey = "";

	int n = eKey.length();

	for (int i = 0; i < n; i++) {
	if (eKey.charAt(i) == 'z')
		arr[0]++;
	if (eKey.charAt(i) == 'w')
		arr[2]++;
	if (eKey.charAt(i) == 'g')
		arr[8]++;
	if (eKey.charAt(i) == 'x')
		arr[6]++;
	if (eKey.charAt(i) == 'v')
		arr[5]++;
	if (eKey.charAt(i) == 'o')
		arr[1]++;
	if (eKey.charAt(i) == 's')
		arr[7]++;
	if (eKey.charAt(i) == 'f')
		arr[4]++;
	if (eKey.charAt(i) == 'h')
		arr[3]++;
	if (eKey.charAt(i) == 'i')
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
		dKey += (char)(i + '0');
	}
	}

	// Return decrypted key
	return dKey;

    }
}
