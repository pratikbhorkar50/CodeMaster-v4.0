import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class EscapeRoom {

	public static void main(String[] args) {
		String encrypetedKey = "XTTIROWISGOFEUH";
		List<Character> encrypetedKeyList = encrypetedKey.chars().mapToObj((i) -> Character.valueOf((char) i))
				.collect(Collectors.toList());

		List<Character> zero = "ZERO".chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());
		List<Character> one = "ONE".chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());
		List<Character> two = "TWO".chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());
		List<Character> three = "THREE".chars().mapToObj((i) -> Character.valueOf((char) i))
				.collect(Collectors.toList());
		List<Character> four = "FOUR".chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());
		List<Character> five = "FIVE".chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());
		List<Character> six = "SIX".chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());
		List<Character> seven = "SEVEN".chars().mapToObj((i) -> Character.valueOf((char) i))
				.collect(Collectors.toList());
		List<Character> eight = "EIGHT".chars().mapToObj((i) -> Character.valueOf((char) i))
				.collect(Collectors.toList());
		List<Character> nine = "NINE".chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());

		List<Character> copiedEncrypetedKeyList = encrypetedKeyList;

		/*
		 * try { File file = new
		 * File("C:\\CodeMaster4\\CodeMaster-v4.0\\Problem2\\Problem2_input.txt");
		 * 
		 * BufferedReader br = new BufferedReader(new FileReader(file));
		 * 
		 * String st;
		 * 
		 * while ((st = br.readLine()) != null) { System.out.println(st); } } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		boolean found = false;
		
		List<Integer> decryptedKey = new ArrayList<Integer>();
		
		while (!found) {

			Character character = copiedEncrypetedKeyList.contains('Z') ? 'Z'
					: copiedEncrypetedKeyList.contains('G') ? 'G'
							: copiedEncrypetedKeyList.contains('W') ? 'W'
									: copiedEncrypetedKeyList.contains('X') ? 'X'
											: copiedEncrypetedKeyList.contains('U') ? 'U'
													: copiedEncrypetedKeyList.contains('R') ? 'R'
															: copiedEncrypetedKeyList.contains('O') ? 'O'
																	: copiedEncrypetedKeyList.contains('F') ? 'F'
																			: copiedEncrypetedKeyList
																					.contains('S')
																							? 'S'
																							: copiedEncrypetedKeyList
																									.contains('N') ? 'N'
																											: 'A';

			switch (character) {
			case 'Z':
				for (Iterator numberIterator = zero.iterator(); numberIterator.hasNext();) {
					copiedEncrypetedKeyList.remove(numberIterator.next());
				}
				decryptedKey.add(0);
				//System.out.println("Number found :" + 0);
				break;

			case 'G':
				for (Iterator numberIterator = eight.iterator(); numberIterator.hasNext();) {
					copiedEncrypetedKeyList.remove(numberIterator.next());
				}
				decryptedKey.add(8);
				//System.out.println("Number found :" + 8);
				break;

			case 'W':
				for (Iterator numberIterator = two.iterator(); numberIterator.hasNext();) {
					copiedEncrypetedKeyList.remove(numberIterator.next());
				}
				decryptedKey.add(2);
				//System.out.println("Number found :" + 2);
				break;

			case 'X':
				for (Iterator numberIterator = six.iterator(); numberIterator.hasNext();) {
					copiedEncrypetedKeyList.remove(numberIterator.next());
				}
				decryptedKey.add(6);
				//System.out.println("Number found :" + 6);
				break;

			case 'U':
				for (Iterator numberIterator = four.iterator(); numberIterator.hasNext();) {
					copiedEncrypetedKeyList.remove(numberIterator.next());
				}
				decryptedKey.add(4);
				//System.out.println("Number found :" + 4);
				break;

			case 'R':
				for (Iterator numberIterator = three.iterator(); numberIterator.hasNext();) {
					copiedEncrypetedKeyList.remove(numberIterator.next());
				}
				decryptedKey.add(3);
				//System.out.println("Number found :" + 3);
				break;

			case 'O':
				for (Iterator numberIterator = one.iterator(); numberIterator.hasNext();) {
					copiedEncrypetedKeyList.remove(numberIterator.next());
				}
				decryptedKey.add(1);
				//System.out.println("Number found :" + 1);
				break;

			case 'F':
				for (Iterator numberIterator = five.iterator(); numberIterator.hasNext();) {
					copiedEncrypetedKeyList.remove(numberIterator.next());
				}
				decryptedKey.add(5);
				//System.out.println("Number found :" + 5);
				break;

			case 'S':
				for (Iterator numberIterator = seven.iterator(); numberIterator.hasNext();) {
					copiedEncrypetedKeyList.remove(numberIterator.next());
				}
				decryptedKey.add(7);
				//System.out.println("Number found :" + 7);
				break;

			case 'N':
				for (Iterator numberIterator = nine.iterator(); numberIterator.hasNext();) {
					copiedEncrypetedKeyList.remove(numberIterator.next());
				}
				decryptedKey.add(9);
				//System.out.println("Number found :" + 9);
				break;
			}
			if (copiedEncrypetedKeyList.size() == 0) {
				break;
			}
		}

		decryptedKey.sort(null);
		String str = Arrays.toString(decryptedKey.toArray()); 
		
		
		System.out.println(str);
	}
}
