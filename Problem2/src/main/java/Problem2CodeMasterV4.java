package main.java;

import java.io.*;

public class Problem2CodeMasterV4 {
    int bufferSize = 8 * 1024;
    String file = "src/main/resources/Problem2_output.txt";
    BufferedWriter writer = new BufferedWriter(new FileWriter(file), bufferSize);

    public Problem2CodeMasterV4() throws IOException {
    }

    public static void main(String args[]) throws IOException {
        Problem2CodeMasterV4 problem2CodeMasterV4 = new Problem2CodeMasterV4();

        System.out.println("Reading and Writing file from resources folder");
        System.out.println("-----------------------------");
        problem2CodeMasterV4.readAndWriteFile("Problem2_input.txt");
        System.out.println("-----------------------------");
    }

    private void readAndWriteFile(String inputFile) throws IOException {
        FileInputStream inputStream = null;
        try {
            String file = "src/main/resources/" + inputFile;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int nbrOfRooms;
            line = reader.readLine();
            nbrOfRooms = Integer.parseInt(line);
            System.out.println("Total no of Rooms: " + nbrOfRooms + "\n");
            int counter = 1;
            while ((line = reader.readLine()) != null) {
                writeDataToFile("Room-" + counter++ + ": " + getNuberFromWord(line));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeDataToFile(String data) throws IOException {
        try {
            writer.write(data);
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getNuberFromWord(String words) {
        int[] temp = new int[10];
        String str = "";
        int num = words.length();

        for (int i = 0; i < num; i++) {
            if (words.charAt(i) == 'Z')
                temp[0]++;
            if (words.charAt(i) == 'W')
                temp[2]++;
            if (words.charAt(i) == 'G')
                temp[8]++;
            if (words.charAt(i) == 'X')
                temp[6]++;
            if (words.charAt(i) == 'V')
                temp[5]++;
            if (words.charAt(i) == 'O')
                temp[1]++;
            if (words.charAt(i) == 'S')
                temp[7]++;
            if (words.charAt(i) == 'F')
                temp[4]++;
            if (words.charAt(i) == 'H')
                temp[3]++;
            if (words.charAt(i) == 'I')
                temp[9]++;
        }
        temp[7] -= temp[6];
        temp[5] -= temp[7];
        temp[4] -= temp[5];
        temp[1] -= (temp[2] + temp[4] + temp[0]);
        temp[3] -= temp[8];
        temp[9] -= (temp[5] + temp[6] + temp[8]);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < temp[i]; j++) {
                str += (char) (i + '0');
            }
        }

        return str;
    }
}
