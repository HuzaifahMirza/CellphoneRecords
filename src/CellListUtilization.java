import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

//Huzaifah Mirza 40136913
//COMP249 
//Assignment #4 part #1
//April 15, 2022
//This program is designed to process a record of cell phones with their serial numbers and add them a to linked list type database. 
//the program then allows the user to modify the list and each nodes data.

/**
 * @author Huzaifah Mirza
 *
 */
public class CellListUtilization {

	public static void main(String[] args) {
		System.out.println(
				"Welcome to the Cellphone Record processing program. This program was brought to you by Huzaifah Mirza.");

		CellList record = new CellList();
		CellList record2 = new CellList();
		Scanner in;
		Scanner input = new Scanner(System.in);
		String word = "";

		try {
			in = new Scanner(new FileInputStream("Cell_Info.txt"));
			while (in.hasNextLine()) {

				long serial = in.nextLong();
				String brand = in.next();
				double price = in.nextDouble();
				int year = in.nextInt();
				Cellphone cell = new Cellphone(serial, brand, year, price);
				if (record.getSize() > 0) {
					if (record.contains(cell.getSerialNum())) {
						continue;
					} else {
						record.addToStart(cell);
					}
				} else {
					record.addToStart(cell);
				}

			}
			System.out.println("Cell_Info.txt added to record successfully.");
			record.showContents();
		}

		catch (FileNotFoundException e) {
			System.out.println("File not found. please try again.");
		}
		int i = 1;
		while (true) {
			System.out.println("please enter a serial number to search for:");
			System.out.println("This is attempt number " + i);
			searchForSerialPrompt(record);
			i++;
			System.out.println("press anykey to search again or q to quit.");
			word = input.nextLine();
			if (word.equals("q")) {
				System.out.println("program will now end.");
				break;
			}

		}
		input.close();

		Cellphone cell = new Cellphone(2, "sony", 1999, 100);
		Cellphone cell2 = new Cellphone(3, "sony", 2012, 600);
		Cellphone cell3 = new Cellphone(4, "sony", 2022, 6000);
		Cellphone cell4 = new Cellphone(5, "sony", 2022, 7000);
		Cellphone cell5 = new Cellphone(10, "sony", 2005, 89);
		CellList list = new CellList();
		System.out.println();
		list.showContents();
		list.addToStart(cell);
		list.addToStart(cell2);
		list.showContents();
		System.out.println("interting at index 0");
		list.insertAtIndex(cell3, 0);
		list.showContents();
		System.out.println("interting at index 2");
		list.insertAtIndex(cell4, 2);
		list.showContents();
		System.out.println("interting at index 5");
		list.insertAtIndex(cell3, 5);
		System.out.println("interting at index 1");
		list.insertAtIndex(cell4, 1);
		list.showContents();

		System.out.println("replacing at index 0");
		list.replaceAtIndex(cell5, 0);
		list.showContents();
		System.out.println("replacing at index 4");
		list.replaceAtIndex(cell5, 4);
		list.showContents();
		System.out.println("replacing at index 2");
		list.replaceAtIndex(cell5, 2);
		list.showContents();
//		
		System.out.println("searching for serial \"3\" in list.");
		System.out.println(list.contains(3));
		System.out.println("searching for serial \"15\" in list.");
		System.out.println(list.contains(15));
		CellList list2 = list.clone();
//		
		System.out.println("creating a clone of the list.");
		list2.showContents();
		list.showContents();
		System.out.println("comparing both lists.");
		System.out.println(list2.equals(list) + " both lists are equals.");
		System.out.println("modifying list and comparing again.");
		list2.deleteFromIndex(2);
		list2.showContents();
		list.showContents();
		System.out.println(list2.equals(list) + " lists are not equal");
		System.out.println("deleting from index 0");
		list.deleteFromIndex(0);
		list.showContents();
		System.out.println("deleting from index 3");
		list.deleteFromIndex(3);
		list.showContents();
		System.out.println("deleting from index 1");
		list.deleteFromIndex(1);
		list.showContents();

	}

	/**
	 * prompts user for serial number to search for in the list
	 * 
	 * @param record
	 */
	public static void searchForSerialPrompt(CellList record) {
		Scanner input = new Scanner(System.in);
		try {
			long num = input.nextLong();

			if (record.contains(num)) {
				System.out.println("The record contains this serial.");

			} else {
				System.out.println("the serial was not found.");

			}
		} catch (InputMismatchException e) {
			System.out.println("the entry was not valid.");
			return;
		}

	}

}
